<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div class="search" v-show="showSearch">
        <el-form :model="queryParams" ref="queryFormRef" :inline="true" label-width="68px">
          <el-form-item label="竞赛类型" prop="competitionTypeId">
            <el-select v-model="queryParams.competitionTypeId" placeholder="请选择竞赛类型" clearable>
              <el-option v-for="dict in types" :key="dict.competitionTypeId" :label="dict.competitionTypeName" :value="dict.competitionTypeId" />
            </el-select>
          </el-form-item>
          <el-form-item label="竞赛名称" prop="competitionName">
            <el-input v-model="queryParams.competitionName" placeholder="请输入竞赛名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
          </el-form-item>
          <el-form-item label="第一作者" prop="competitionStudentId">
            <el-select
              v-model="queryParams.competitionStudentId"
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
          <el-form-item label="其他成员" prop="competitionOtherStudentIds">
            <el-select
              v-model="queryParams.competitionOtherStudentIds"
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
          <el-form-item label="其他老师" prop="competitionOtherTeacherIds">
            <el-select
              v-model="queryParams.competitionOtherTeacherIds"
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
          <el-form-item label="竞赛状态" prop="status">
            <el-select v-model="queryParams.status" placeholder="请选择竞赛状态" clearable>
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
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['business:stuCompetition:edit']"
              >修改
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['business:stuCompetition:export']">导出 </el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="competitionList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="竞赛id" align="center" prop="competitionId" v-if="false" />
        <el-table-column label="竞赛类型id" align="center" prop="competitionTypeId" v-if="false" />
        <el-table-column label="竞赛类型" align="center" prop="competitionTypeName" />
        <el-table-column label="竞赛名称" align="center" prop="competitionName" />
        <el-table-column label="第一作者id" align="center" prop="competitionStudentId" v-if="false" />
        <el-table-column label="第一作者" align="center" prop="competitionStudentName" />
        <el-table-column label="所属部门id" align="center" prop="competitionStudentDeptId" v-if="false" />
        <el-table-column label="所属部门" align="center" prop="competitionStudentDeptName" />
        <el-table-column label="指导老师id" align="center" prop="competitionTeacherId" v-if="false" />
        <el-table-column label="指导老师" align="center" prop="competitionTeacherName" />
        <el-table-column label="其他成员id" align="center" prop="competitionOtherStudentIds" v-if="false" />
        <el-table-column label="其他成员" align="center" prop="competitionOtherStudentNames" />
        <el-table-column label="其他老师id" align="center" prop="competitionOtherTeacherIds" v-if="false" />
        <el-table-column label="其他老师" align="center" prop="competitionOtherTeacherNames" />
        <el-table-column label="佐证材料" align="center" prop="competitionEvidenceUrl">
          <template #default="scope">
            <el-button type="primary" link @click="download(scope.row.competitionEvidenceUrl);">点我下载</el-button>
          </template>
        </el-table-column>
        <el-table-column label="审核反馈" align="center" prop="competitionFeedback" />
        <el-table-column label="竞赛状态" align="center" prop="status">
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['business:stuCompetition:edit']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total>0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 修改在校竞赛管理对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="competitionFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="竞赛类型" prop="competitionTypeId">
          <el-select v-model="form.competitionTypeId" placeholder="无" disabled clearable style="width: 100%;">
            <el-option v-for="dict in types" :key="dict.competitionTypeId" :label="dict.competitionTypeName" :value="dict.competitionTypeId" />
          </el-select>
        </el-form-item>
        <el-form-item label="竞赛名称" prop="competitionName">
          <el-input v-model="form.competitionName" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="指导老师" prop="competitionTeacherName">
          <el-input v-model="form.competitionTeacherName" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="其他成员" prop="competitionOtherStudentNames">
          <el-input v-model="form.competitionOtherStudentNames" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="其他老师" prop="competitionOtherTeacherNames">
          <el-input v-model="form.competitionOtherTeacherNames" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="审核反馈" prop="competitionFeedback">
          <el-input v-model="form.competitionFeedback" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="竞赛状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择竞赛状态" clearable style="width: 100%;">
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

<script setup name="Competition" lang="ts">
import {
  listCompetition,
  getCompetition,
  updateCompetition,
} from '@/api/business/stuCompetition';
import {CompetitionVO, CompetitionQuery, CompetitionForm} from '@/api/business/stuCompetition/types';
import {listCompetitionAvailable} from "@/api/base/competition";
import {CompetitionVO as CompetitionTypeVO} from "@/api/base/competition/types";
import {UserByNickName} from "@/api/system/user/types";
import {listByNickName} from "@/api/system/user";

const {proxy} = getCurrentInstance() as ComponentInternalInstance;
const {business_experience_type} = toRefs<any>(proxy?.useDict('business_experience_type'));

const competitionList = ref<CompetitionVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const types = ref<CompetitionTypeVO[]>([]);
const student = ref<UserByNickName[]>([]);
const members = ref<UserByNickName[]>([]);
const teachers = ref<UserByNickName[]>([]);
const membersAddEdit = ref<UserByNickName[]>([]);
const teacherAddEdit = ref<UserByNickName[]>([]);
const teachersAddEdit = ref<UserByNickName[]>([]);
const queryFormRef = ref<ElFormInstance>();
const competitionFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: CompetitionForm = {
  competitionId: undefined,
  competitionTypeId: undefined,
  competitionTypeName: undefined,
  competitionName: undefined,
  competitionStudentId: undefined,
  competitionStudentName: undefined,
  competitionStudentDeptId: undefined,
  competitionStudentDeptName: undefined,
  competitionTeacherId: undefined,
  competitionTeacherName: undefined,
  competitionOtherStudentIds: undefined,
  competitionOtherStudentNames: undefined,
  competitionOtherTeacherIds: undefined,
  competitionOtherTeacherNames: undefined,
  competitionEvidenceUrl: undefined,
  competitionFeedback: undefined,
  status: undefined,
  remark: undefined
}
/** 自定义校验竞赛状态 */
const validateStatus = (rule: any, value: any, callback: any) => {
  if (value === '0') {
    callback(new Error('请修改审核状态'))
  } else {
    callback()
  }
}

const data = reactive<PageData<CompetitionForm, CompetitionQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    competitionTypeId: undefined,
    competitionName: undefined,
    competitionStudentId: undefined,
    competitionStudentDeptId: undefined,
    competitionTeacherId: undefined,
    competitionOtherStudentIds: undefined,
    competitionOtherTeacherIds: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    competitionId: [
      {required: true, message: "竞赛id不能为空", trigger: "blur"}
    ],
    competitionFeedback: [
      {required: true, message: "审核反馈不能为空", trigger: "blur"}
    ],
    status: [
      {required: true, validator: validateStatus, trigger: "blur"}
    ]
  }
});

const {queryParams, form, rules} = toRefs(data);

/** 查询在校竞赛管理列表 */
const getList = async () => {
  loading.value = true;
  const data = JSON.parse(JSON.stringify(queryParams.value))
  if (Array.isArray(data.competitionOtherStudentIds) && data.competitionOtherStudentIds.length != 0) {
    data.competitionOtherStudentIds = data.competitionOtherStudentIds.join(",")
  }
  if (Array.isArray(data.competitionOtherTeacherIds) && data.competitionOtherTeacherIds.length != 0) {
    data.competitionOtherTeacherIds = data.competitionOtherTeacherIds.join(",")
  }
  const res = await listCompetition(data);
  competitionList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 查询竞赛类型 */
const getTypeList = async () => {
  const res = await listCompetitionAvailable();
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

/** 修改按钮操作 */
const handleUpdate = (row?: CompetitionVO) => {
  loading.value = true
  dialog.visible = true;
  dialog.title = "修改在校竞赛管理";
  // fileList.value = []
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
      const data = JSON.parse(JSON.stringify(form.value))
      if (Array.isArray(data.competitionOtherStudentIds) && data.competitionOtherStudentIds.length != 0) {
        data.competitionOtherStudentIds = data.competitionOtherStudentIds.join(",")
      }
      if (Array.isArray(data.competitionOtherTeacherIds) && data.competitionOtherTeacherIds.length != 0) {
        data.competitionOtherTeacherIds = data.competitionOtherTeacherIds.join(",")
      }
      if (form.value.competitionId) {
        await updateCompetition(data).finally(() => buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("修改成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('business/competition/stu/export', {
    ...queryParams.value
  }, `competition_${new Date().getTime()}.xlsx`)
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
