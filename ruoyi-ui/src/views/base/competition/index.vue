<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div class="search" v-show="showSearch">
        <el-form :model="queryParams" ref="queryFormRef" :inline="true" label-width="68px">
          <el-form-item label="竞赛名称" prop="competitionName">
            <el-input v-model="queryParams.competitionName" placeholder="请输入竞赛名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
          </el-form-item>
          <el-form-item label="竞赛状态" prop="status">
            <el-select v-model="queryParams.status" placeholder="请选择竞赛状态" clearable>
              <el-option
                v-for="dict in sys_normal_disable"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['base:competition:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['base:competition:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['base:competition:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['base:competition:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="competitionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="竞赛id" align="center" prop="competitionId" v-if="false" />
        <el-table-column label="竞赛名称" align="center" prop="competitionName" />
        <el-table-column label="竞赛状态" align="center" prop="status">
          <template #default="scope">
            <dict-tag :options="sys_normal_disable" :value="scope.row.status"/>
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['base:competition:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['base:competition:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination
          v-show="total>0"
          :total="total"
          v-model:page="queryParams.pageNum"
          v-model:limit="queryParams.pageSize"
          @pagination="getList"
      />
    </el-card>
    <!-- 添加或修改竞赛类型对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="competitionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="竞赛名称" prop="competitionName">
          <el-input v-model="form.competitionName" placeholder="请输入竞赛名称" style="width: 100%" />
        </el-form-item>
        <el-form-item label="竞赛状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择竞赛状态" style="width: 100%">
            <el-option
                v-for="dict in sys_normal_disable"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            ></el-option>
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

<script setup name="Competition" lang="ts">
import { listCompetition, getCompetition, delCompetition, addCompetition, updateCompetition } from '@/api/base/competition';
import { CompetitionVO, CompetitionQuery, CompetitionForm } from '@/api/base/competition/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;
const { sys_normal_disable } = toRefs<any>(proxy?.useDict('sys_normal_disable'));

const competitionList = ref<CompetitionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const competitionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: CompetitionForm = {
  competitionId: undefined,
  competitionName: undefined,
  status: undefined,
}
const data = reactive<PageData<CompetitionForm, CompetitionQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    competitionName: undefined,
    status: undefined,
    params: {
    }
  },
  rules: {
    competitionId: [
      { required: true, message: "竞赛id不能为空", trigger: "blur" }
    ],
    competitionName: [
      { required: true, message: "竞赛名称不能为空", trigger: "blur" }
    ],
    status: [
      { required: true, message: "竞赛状态不能为空", trigger: "change" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询竞赛类型列表 */
const getList = async () => {
  loading.value = true;
  const res = await listCompetition(queryParams.value);
  competitionList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  competitionFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: CompetitionVO[]) => {
  ids.value = selection.map(item => item.competitionId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  dialog.visible = true;
  dialog.title = "添加竞赛类型";
  nextTick(() => {
    reset();
  });
}

/** 修改按钮操作 */
const handleUpdate = (row?: CompetitionVO) => {
  loading.value = true
  dialog.visible = true;
  dialog.title = "修改竞赛类型";
  nextTick(async () => {
    reset();
    const _competitionId = row?.competitionId || ids.value[0]
    const res = await getCompetition(_competitionId);
    loading.value = false;
    Object.assign(form.value, res.data);
  });
}

/** 提交按钮 */
const submitForm = () => {
  competitionFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.competitionId) {
        await updateCompetition(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addCompetition(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("修改成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: CompetitionVO) => {
  const _competitionIds = row?.competitionId || ids.value;
  await proxy?.$modal.confirm('是否确认删除竞赛类型编号为"' + _competitionIds + '"的数据项？').finally(() => loading.value = false);
  await delCompetition(_competitionIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('base/competition/export', {
    ...queryParams.value
  }, `competition_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
