<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div class="search" v-show="showSearch">
        <el-form :model="queryParams" ref="queryFormRef" :inline="true" label-width="68px">
          <el-form-item label="荣誉类型" prop="honorTypeId">
            <el-select v-model="queryParams.honorTypeId" placeholder="请选择荣誉类型" clearable>
              <el-option v-for="dict in types" :key="dict.honorTypeId" :label="dict.honorTypeName" :value="dict.honorTypeId" />
            </el-select>
          </el-form-item>
          <el-form-item label="荣誉名称" prop="honorName">
            <el-input v-model="queryParams.honorName" placeholder="请输入荣誉名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
          </el-form-item>
          <el-form-item label="第一作者" prop="honorStudentId">
            <el-select
              v-model="queryParams.honorStudentId"
              clearable
              filterable
              remote
              reserve-keyword
              placeholder="请搜索第一作者"
              :remote-method="(query) => getUserByNickName(query,'student')"
              :loading="loading"
              style="width: 240px"
            >
              <el-option v-for="item in student" :key="item.userId" :label="item.nickName" :value="item.userId">
                <span style="float: left">{{ item.nickName }}</span>
                <el-divider direction="vertical" />
                <span style="float: right;color: var(--el-text-color-secondary);font-size: 13px;">
                  {{ item.deptName }}
                </span>
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="其他成员" prop="honorOtherStudentIds">
            <el-select
              v-model="queryParams.honorOtherStudentIds"
              clearable
              multiple
              filterable
              remote
              reserve-keyword
              placeholder="请搜索其他成员"
              :multiple-limit="20"
              :remote-method="(query) => getUserByNickName(query,'members')"
              :loading="loading"
              style="width: 240px"
            >
              <el-option v-for="item in members" :key="item.userId" :label="item.nickName" :value="item.userId">
                <span style="float: left">{{ item.nickName }}</span>
                <el-divider direction="vertical" />
                <span style="float: right;color: var(--el-text-color-secondary);font-size: 13px;">
                  {{ item.deptName }}
                </span>
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="其他老师" prop="honorOtherTeacherIds">
            <el-select
              v-model="queryParams.honorOtherTeacherIds"
              clearable
              multiple
              filterable
              remote
              reserve-keyword
              placeholder="请搜索其他老师"
              :multiple-limit="10"
              :remote-method="(query) => getUserByNickName(query,'teachers')"
              :loading="loading"
              style="width: 240px"
            >
              <el-option v-for="item in teachers" :key="item.userId" :label="item.nickName" :value="item.userId">
                <span style="float: left">{{ item.nickName }}</span>
                <el-divider direction="vertical" />
                <span style="float: right;color: var(--el-text-color-secondary);font-size: 13px;">
                  {{ item.deptName }}
                </span>
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="荣誉状态" prop="status">
            <el-select v-model="queryParams.status" placeholder="请选择荣誉状态" clearable>
              <el-option v-for="dict in business_experience_type" :key="dict.value" :label="dict.label" :value="dict.value" />
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
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['business:stuHonor:edit']"
              >修改
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['business:stuHonor:export']">导出 </el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="honorList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="荣誉id" align="center" prop="honorId" v-if="false" />
        <el-table-column label="荣誉类型id" align="center" prop="honorTypeId" v-if="false" />
        <el-table-column label="荣誉类型" align="center" prop="honorTypeName" />
        <el-table-column label="荣誉名称" align="center" prop="honorName" />
        <el-table-column label="第一作者id" align="center" prop="honorStudentId" v-if="false" />
        <el-table-column label="第一作者" align="center" prop="honorStudentName" />
        <el-table-column label="所属部门id" align="center" prop="honorStudentDeptId" v-if="false" />
        <el-table-column label="所属部门" align="center" prop="honorStudentDeptName" />
        <el-table-column label="指导老师id" align="center" prop="honorTeacherId" v-if="false" />
        <el-table-column label="指导老师" align="center" prop="honorTeacherName" />
        <el-table-column label="其他成员id" align="center" prop="honorOtherStudentIds" v-if="false" />
        <el-table-column label="其他成员" align="center" prop="honorOtherStudentNames" />
        <el-table-column label="其他老师id" align="center" prop="honorOtherTeacherIds" v-if="false" />
        <el-table-column label="其他老师" align="center" prop="honorOtherTeacherNames" />
        <el-table-column label="佐证材料" align="center" prop="honorEvidenceUrl">
          <template #default="scope">
            <el-button type="primary" link @click="download(scope.row.honorEvidenceUrl);">点我下载</el-button>
          </template>
        </el-table-column>
        <el-table-column label="审核反馈" align="center" prop="honorFeedback" />
        <el-table-column label="荣誉状态" align="center" prop="status">
          <template #default="scope">
            <dict-tag :options="business_experience_type" :value="scope.row.status" />
          </template>
        </el-table-column>
        <el-table-column label="创建时间" align="center" prop="createTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['business:stuHonor:edit']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total>0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 修改在校荣誉管理对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="honorFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="荣誉类型" prop="honorTypeId">
          <el-select v-model="form.honorTypeId" placeholder="无" disabled clearable style="width: 100%;">
            <el-option v-for="dict in types" :key="dict.honorTypeId" :label="dict.honorTypeName" :value="dict.honorTypeId" />
          </el-select>
        </el-form-item>
        <el-form-item label="荣誉名称" prop="honorName">
          <el-input v-model="form.honorName" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="指导老师" prop="honorTeacherName">
          <el-input v-model="form.honorTeacherName" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="其他成员" prop="honorOtherStudentNames">
          <el-input v-model="form.honorOtherStudentNames" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="其他老师" prop="honorOtherTeacherNames">
          <el-input v-model="form.honorOtherTeacherNames" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="审核反馈" prop="honorFeedback">
          <el-input v-model="form.honorFeedback" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="荣誉状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择荣誉状态" clearable style="width: 100%;">
            <el-option v-for="dict in business_experience_type" :key="dict.value" :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" disabled placeholder="请输入内容" />
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

<script setup name="Honor" lang="ts">
import {
  listHonor,
  getHonor,
  updateHonor,
} from '@/api/business/stuHonor';
import {HonorVO, HonorQuery, HonorForm} from '@/api/business/stuHonor/types';
import {listHonorAvailable} from "@/api/base/honor";
import {HonorVO as HonorTypeVO} from "@/api/base/honor/types";
import {UserByNickName} from "@/api/system/user/types";
import {listByNickName} from "@/api/system/user";

const {proxy} = getCurrentInstance() as ComponentInternalInstance;
const {business_experience_type} = toRefs<any>(proxy?.useDict('business_experience_type'));

const honorList = ref<HonorVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const types = ref<HonorTypeVO[]>([]);
const student = ref<UserByNickName[]>([]);
const members = ref<UserByNickName[]>([]);
const teachers = ref<UserByNickName[]>([]);
const membersAddEdit = ref<UserByNickName[]>([]);
const teacherAddEdit = ref<UserByNickName[]>([]);
const teachersAddEdit = ref<UserByNickName[]>([]);
const queryFormRef = ref<ElFormInstance>();
const honorFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: HonorForm = {
  honorId: undefined,
  honorTypeId: undefined,
  honorTypeName: undefined,
  honorName: undefined,
  honorStudentId: undefined,
  honorStudentName: undefined,
  honorStudentDeptId: undefined,
  honorStudentDeptName: undefined,
  honorTeacherId: undefined,
  honorTeacherName: undefined,
  honorOtherStudentIds: undefined,
  honorOtherStudentNames: undefined,
  honorOtherTeacherIds: undefined,
  honorOtherTeacherNames: undefined,
  honorEvidenceUrl: undefined,
  honorFeedback: undefined,
  status: undefined,
  remark: undefined
}
/** 自定义校验荣誉状态 */
const validateStatus = (rule: any, value: any, callback: any) => {
  if (value === '0') {
    callback(new Error('请修改审核状态'))
  } else {
    callback()
  }
}

const data = reactive<PageData<HonorForm, HonorQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    honorTypeId: undefined,
    honorName: undefined,
    honorStudentId: undefined,
    honorStudentDeptId: undefined,
    honorTeacherId: undefined,
    honorOtherStudentIds: undefined,
    honorOtherTeacherIds: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    honorId: [
      {required: true, message: "荣誉id不能为空", trigger: "blur"}
    ],
    honorFeedback: [
      {required: true, message: "审核反馈不能为空", trigger: "blur"}
    ],
    status: [
      {required: true, validator: validateStatus, trigger: "blur"}
    ]
  }
});

const {queryParams, form, rules} = toRefs(data);

/** 查询在校荣誉管理列表 */
const getList = async () => {
  loading.value = true;
  const data = JSON.parse(JSON.stringify(queryParams.value))
  if (Array.isArray(data.honorOtherStudentIds) && data.honorOtherStudentIds.length != 0) {
    data.honorOtherStudentIds = data.honorOtherStudentIds.join(",")
  }
  if (Array.isArray(data.honorOtherTeacherIds) && data.honorOtherTeacherIds.length != 0) {
    data.honorOtherTeacherIds = data.honorOtherTeacherIds.join(",")
  }
  const res = await listHonor(data);
  honorList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 查询荣誉类型 */
const getTypeList = async () => {
  const res = await listHonorAvailable();
  types.value = res.data;
}

/** 根据名称获取用户信息 */
const getUserByNickName = async (nickname: string, type: string) => {
  if (nickname) {
    const res = await listByNickName(nickname);
    if (type === "student") {
      student.value = res.data
    } else if (type === "members") {
      members.value = res.data
    } else if (type === "teachers") {
      teachers.value = res.data
    } else if (type === "membersAddEdit") {
      membersAddEdit.value = res.data
    } else if (type === "teacherAddEdit") {
      teacherAddEdit.value = res.data
    } else if (type === "teachersAddEdit") {
      teachersAddEdit.value = res.data
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
  honorFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: HonorVO[]) => {
  ids.value = selection.map(item => item.honorId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 修改按钮操作 */
const handleUpdate = (row?: HonorVO) => {
  loading.value = true
  dialog.visible = true;
  dialog.title = "修改在校荣誉管理";
  // fileList.value = []
  nextTick(async () => {
    reset();
    const _honorId = row?.honorId || ids.value[0]
    const res = await getHonor(_honorId);
    loading.value = false;
    Object.assign(form.value, res.data);
  });
}

/** 提交按钮 */
const submitForm = () => {
  honorFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      const data = JSON.parse(JSON.stringify(form.value))
      if (Array.isArray(data.honorOtherStudentIds) && data.honorOtherStudentIds.length != 0) {
        data.honorOtherStudentIds = data.honorOtherStudentIds.join(",")
      }
      if (Array.isArray(data.honorOtherTeacherIds) && data.honorOtherTeacherIds.length != 0) {
        data.honorOtherTeacherIds = data.honorOtherTeacherIds.join(",")
      }
      if (form.value.honorId) {
        await updateHonor(data).finally(() => buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("修改成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('business/honor/stu/export', {
    ...queryParams.value
  }, `honor_${new Date().getTime()}.xlsx`)
}

/** 文件下载 */
const download = (url: string) => {
  // Fetch the file data from the URL
  fetch(url)
    .then(response => response.blob())
    .then(blob => {
      // Create a new Blob object with the desired MIME type
      const newBlob = new Blob([blob], {type: 'application/octet-stream'});

      // Create a URL for the Blob object
      const downloadUrl = URL.createObjectURL(newBlob);

      // Create an <a> element and set attributes
      const link = document.createElement('a');
      link.href = downloadUrl;
      // link.href = url;
      const suffix = url.substring(url.lastIndexOf('.'))
      if (suffix) {
        link.download = Date.parse(new Date().toString()) + "." + suffix;
      } else {
        link.download = Date.parse(new Date().toString()) + ".unknown"
      }
      document.body.appendChild(link); // Append to document to ensure it can be clicked
      link.click(); // Simulate click to start download
      document.body.removeChild(link); // Remove element after download
      URL.revokeObjectURL(downloadUrl); // Release Blob URL resource
    })
    .catch(error => proxy?.$modal.msgError("文件下载失败:" + error));
};

onMounted(() => {
  getList();
  getTypeList();
});
</script>
