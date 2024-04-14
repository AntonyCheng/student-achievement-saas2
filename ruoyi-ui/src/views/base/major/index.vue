<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div class="search" v-show="showSearch">
        <el-form :model="queryParams" ref="queryFormRef" :inline="true" label-width="68px">
          <el-form-item label="专业部门" prop="deptId">
            <el-select v-model="queryParams.deptId" placeholder="请选择专业部门" clearable style="width: 100%;">
              <el-option v-for="dept in deptArray" :key="dept.deptId" :label="dept.deptName" :value="dept.deptId" />
            </el-select>
          </el-form-item>
          <el-form-item label="专业名称" prop="majorName">
            <el-input v-model="queryParams.majorName" placeholder="请输入专业名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
          </el-form-item>
          <el-form-item label="专业年级" prop="majorGrade">
            <el-select v-model="queryParams.majorGrade" placeholder="请选择专业年级" clearable>
              <el-option v-for="dict in base_major_grade" :key="dict.value" :label="dict.label" :value="dict.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="专业状态" prop="status">
            <el-select v-model="queryParams.status" placeholder="请选择专业状态" clearable>
              <el-option v-for="dict in sys_normal_disable" :key="dict.value" :label="dict.label" :value="dict.value" />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
            <el-button icon="Refresh" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['base:major:add']">新增 </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['base:major:edit']">修改 </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['base:major:remove']"
              >删除
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['base:major:export']"> 导出 </el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="majorList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="专业id" align="center" prop="majorId" v-if="false" />
        <el-table-column label="部门id" align="center" prop="deptId" v-if="false" />
        <el-table-column label="部门名称" align="center" prop="deptName" />
        <el-table-column label="专业名称" align="center" prop="majorName" />
        <el-table-column label="专业年级" align="center" prop="majorGrade">
          <template #default="scope">
            <dict-tag :options="base_major_grade" :value="scope.row.majorGrade" />
          </template>
        </el-table-column>
        <el-table-column label="专业状态" align="center" prop="status">
          <template #default="scope">
            <dict-tag :options="sys_normal_disable" :value="scope.row.status" />
          </template>
        </el-table-column>
        <el-table-column label="创建时间" align="center" prop="createTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['base:major:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['base:major:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total>0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改专业对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="majorFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="专业部门" prop="deptId">
          <el-select v-model="form.deptId" placeholder="请选择专业部门" clearable style="width: 100%;">
            <el-option v-for="dept in deptArray" :key="dept.deptId" :label="dept.deptName" :value="dept.deptId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="专业名称" prop="majorName">
          <el-input v-model="form.majorName" placeholder="请输入专业名称" />
        </el-form-item>
        <el-form-item label="专业年级" prop="majorGrade">
          <el-select v-model="form.majorGrade" placeholder="请选择专业年级" style="width: 100%;">
            <el-option v-for="dict in base_major_grade" :key="dict.value" :label="dict.label" :value="dict.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="专业状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择专业状态" style="width: 100%;">
            <el-option v-for="dict in sys_normal_disable" :key="dict.value" :label="dict.label" :value="dict.value"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Major" lang="ts">
import {listMajor, getMajor, delMajor, addMajor, updateMajor} from '@/api/base/major';
import {MajorVO, MajorQuery, MajorForm} from '@/api/base/major/types';
import {listDept} from "@/api/system/dept";

const {proxy} = getCurrentInstance() as ComponentInternalInstance;
const {sys_normal_disable, base_major_grade} = toRefs<any>(proxy?.useDict('sys_normal_disable', 'base_major_grade'));

const majorList = ref<MajorVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const deptArray = ref<any>([]);

const queryFormRef = ref<ElFormInstance>();
const majorFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: MajorForm = {
  majorId: undefined,
  deptId: undefined,
  majorName: undefined,
  majorGrade: undefined,
  status: undefined,
}
const data = reactive<PageData<MajorForm, MajorQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    deptId: undefined,
    majorName: undefined,
    majorGrade: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    deptId: [
      {required: true, message: "部门id不能为空", trigger: "blur"}
    ],
    majorName: [
      {required: true, message: "专业名称不能为空", trigger: "blur"}
    ],
    majorGrade: [
      {required: true, message: "专业年级不能为空", trigger: "change"}
    ],
    status: [
      {required: true, message: "专业状态不能为空", trigger: "change"}
    ],
  }
});

const {queryParams, form, rules} = toRefs(data);

/** 查询专业列表 */
const getList = async () => {
  loading.value = true;
  const res = await listMajor(queryParams.value);
  majorList.value = res.rows;
  majorList.value.forEach(major=>{
    for (let i in deptArray.value) {
      if (major.deptId === deptArray.value[i].deptId) {
        major.deptName = deptArray.value[i].deptName;
      }
    }
  })
  total.value = res.total;
  loading.value = false;
}

/** 查询子部门选择数据 */
const getDeptSelect = async () => {
  const {data} = await listDept();
  for (let i in data) {
    if (data[i].parentId !==0){
      deptArray.value.push({"deptId": data[i].deptId, "deptName": data[i].deptName})
    }
  }
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  majorFormRef.value?.resetFields();
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
}

/** 多选框选中数据 */
const handleSelectionChange = (selection: MajorVO[]) => {
  ids.value = selection.map(item => item.majorId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  dialog.visible = true;
  dialog.title = "添加专业";
  nextTick(() => {
    reset();
  });
}

/** 修改按钮操作 */
const handleUpdate = (row?: MajorVO) => {
  loading.value = true
  dialog.visible = true;
  dialog.title = "修改专业";
  nextTick(async () => {
    reset();
    const _majorId = row?.majorId || ids.value[0]
    const res = await getMajor(_majorId);
    loading.value = false;
    Object.assign(form.value, res.data);
  });
}

/** 提交按钮 */
const submitForm = () => {
  majorFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.majorId) {
        await updateMajor(form.value).finally(() => buttonLoading.value = false);
      } else {
        await addMajor(form.value).finally(() => buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("修改成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: MajorVO) => {
  const _majorIds = row?.majorId || ids.value;
  await proxy?.$modal.confirm('是否确认删除专业编号为"' + _majorIds + '"的数据项？').finally(() => loading.value = false);
  await delMajor(_majorIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('base/major/export', {
    ...queryParams.value
  }, `major_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getDeptSelect(); // 初始化部门数据
  getList(); // 初始化列表数据
});
</script>
