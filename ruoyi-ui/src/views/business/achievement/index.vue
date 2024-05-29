<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div class="search" v-show="showSearch">
        <el-form :model="queryParams" ref="queryFormRef" :inline="true" label-width="68px">
          <el-form-item label="成果类型" prop="achievementTypeId">
            <el-select v-model="queryParams.achievementTypeId" placeholder="请选择成果类型" clearable>
              <el-option v-for="dict in types" :key="dict.achievementTypeId" :label="dict.achievementTypeName" :value="dict.achievementTypeId" />
            </el-select>
          </el-form-item>
          <el-form-item label="成果名称" prop="achievementName">
            <el-input v-model="queryParams.achievementName" placeholder="请输入成果名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
          </el-form-item>
          <el-form-item label="第一作者" prop="achievementStudentId">
            <el-select
              v-model="queryParams.achievementStudentId"
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
          <el-form-item label="指导老师" prop="achievementTeacherId">
            <el-select
              v-model="queryParams.achievementTeacherId"
              clearable
              filterable
              remote
              reserve-keyword
              placeholder="请搜索第一指导老师"
              :remote-method="(query) => getUserByNickName(query,'teacher')"
              :loading="loading"
              style="width: 240px"
            >
              <el-option v-for="item in teacher" :key="item.userId" :label="item.nickName" :value="item.userId">
                <span style="float: left">{{ item.nickName }}</span>
                <el-divider direction="vertical" />
                <span style="float: right;color: var(--el-text-color-secondary);font-size: 13px;">
                  {{ item.deptName }}
                </span>
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="其他成员" prop="achievementOtherStudentIds">
            <el-select
              v-model="queryParams.achievementOtherStudentIds"
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
          <el-form-item label="其他老师" prop="achievementOtherTeacherIds">
            <el-select
              v-model="queryParams.achievementOtherTeacherIds"
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
          <el-form-item label="成果状态" prop="status">
            <el-select v-model="queryParams.status" placeholder="请选择成果状态" clearable>
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
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['business:achievement:edit']"
              >详情
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['business:achievement:remove']"
              >删除
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['business:achievement:export']">导出 </el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="achievementList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="成果id" align="center" prop="achievementId" v-if="false" />
        <el-table-column label="成果类型id" align="center" prop="achievementTypeId" v-if="false" />
        <el-table-column label="成果类型" align="center" prop="achievementTypeName" />
        <el-table-column label="成果名称" align="center" prop="achievementName" />
        <el-table-column label="第一作者id" align="center" prop="achievementStudentId" v-if="false" />
        <el-table-column label="第一作者" align="center" prop="achievementStudentName" />
        <el-table-column label="所属部门id" align="center" prop="achievementStudentDeptId" v-if="false" />
        <el-table-column label="所属部门" align="center" prop="achievementStudentDeptName" />
        <el-table-column label="指导老师id" align="center" prop="achievementTeacherId" v-if="false" />
        <el-table-column label="指导老师" align="center" prop="achievementTeacherName" />
        <el-table-column label="其他成员id" align="center" prop="achievementOtherStudentIds" v-if="false" />
        <el-table-column label="其他成员" align="center" prop="achievementOtherStudentNames" />
        <el-table-column label="其他老师id" align="center" prop="achievementOtherTeacherIds" v-if="false" />
        <el-table-column label="其他老师" align="center" prop="achievementOtherTeacherNames" />
        <el-table-column label="佐证材料" align="center" prop="achievementEvidenceUrl">
          <template #default="scope">
            <el-button type="primary" link @click="download(scope.row.achievementEvidenceUrl);">点我下载</el-button>
          </template>
        </el-table-column>
        <el-table-column label="审核反馈" align="center" prop="achievementFeedback" />
        <el-table-column label="成果状态" align="center" prop="status">
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
            <el-tooltip content="详情" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['business:achievement:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['business:achievement:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <pagination v-show="total>0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 查看详情在校成果管理对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="achievementFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="成果类型" prop="achievementTypeId">
          <el-select v-model="form.achievementTypeId" placeholder="请选择成果类型" clearable style="width: 100%;" disabled>
            <el-option v-for="dict in types" :key="dict.achievementTypeId" :label="dict.achievementTypeName" :value="dict.achievementTypeId" />
          </el-select>
        </el-form-item>
        <el-form-item label="成果名称" prop="achievementName">
          <el-input v-model="form.achievementName" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="指导老师" prop="achievementTeacherName">
          <el-input v-model="form.achievementTeacherName" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="其他成员" prop="achievementOtherStudentNames">
          <el-input v-model="form.achievementOtherStudentNames" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="其他老师" prop="achievementOtherTeacherNames">
          <el-input v-model="form.achievementOtherTeacherNames" placeholder="无" disabled />
        </el-form-item>
        <el-form-item label="佐证材料" prop="achievementEvidenceUrl">
          <el-button type="success" link @click="download(form.achievementEvidenceUrl);">点我下载</el-button>
        </el-form-item>
        <el-form-item label="审核反馈" prop="achievementFeedback">
          <el-input v-model="form.achievementFeedback" type="textarea" placeholder="请输入内容" disabled />
        </el-form-item>
        <el-form-item label="成果状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择成果状态" clearable style="width: 100%;" disabled>
            <el-option v-for="dict in business_experience_type" :key="dict.value" :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" disabled />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="cancel">确 定</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Achievement" lang="ts">
import {
  listAchievement,
  getAchievement,
  delAchievement,
} from '@/api/business/achievement';
import {AchievementVO, AchievementQuery, AchievementForm} from '@/api/business/achievement/types';
import {listAchievementAvailable} from "@/api/base/achievement";
import {AchievementVO as AchievementTypeVO} from "@/api/base/achievement/types";
import {UserByNickName} from "@/api/system/user/types";
import {listByNickName} from "@/api/system/user";

const {proxy} = getCurrentInstance() as ComponentInternalInstance;
const {business_experience_type} = toRefs<any>(proxy?.useDict('business_experience_type'));

const achievementList = ref<AchievementVO[]>([]);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const types = ref<AchievementTypeVO[]>([]);
const student = ref<UserByNickName[]>([]);
const teacher = ref<UserByNickName[]>([]);
const members = ref<UserByNickName[]>([]);
const teachers = ref<UserByNickName[]>([]);
const membersAddEdit = ref<UserByNickName[]>([]);
const teacherAddEdit = ref<UserByNickName[]>([]);
const teachersAddEdit = ref<UserByNickName[]>([]);

const queryFormRef = ref<ElFormInstance>();
const achievementFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: AchievementForm = {
  achievementId: undefined,
  achievementTypeId: undefined,
  achievementTypeName: undefined,
  achievementName: undefined,
  achievementStudentId: undefined,
  achievementStudentName: undefined,
  achievementStudentDeptId: undefined,
  achievementStudentDeptName: undefined,
  achievementTeacherId: undefined,
  achievementTeacherName: undefined,
  achievementOtherStudentIds: undefined,
  achievementOtherStudentNames: undefined,
  achievementOtherTeacherIds: undefined,
  achievementOtherTeacherNames: undefined,
  achievementEvidenceUrl: undefined,
  achievementFeedback: undefined,
  status: undefined,
  remark: undefined
}
const data = reactive<PageData<AchievementForm, AchievementQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    achievementTypeId: undefined,
    achievementName: undefined,
    achievementStudentId: undefined,
    achievementStudentDeptId: undefined,
    achievementTeacherId: undefined,
    achievementOtherStudentIds: undefined,
    achievementOtherTeacherIds: undefined,
    status: undefined,
    params: {}
  },
  rules: {
    achievementId: [
      {required: true, message: "成果id不能为空", trigger: "blur"}
    ]
  }
});

const {queryParams, form, rules} = toRefs(data);

/** 查询在校成果管理列表 */
const getList = async () => {
  loading.value = true;
  const data = JSON.parse(JSON.stringify(queryParams.value))
  if (Array.isArray(data.achievementOtherStudentIds) && data.achievementOtherStudentIds.length != 0) {
    data.achievementOtherStudentIds = data.achievementOtherStudentIds.join(",")
  }
  if (Array.isArray(data.achievementOtherTeacherIds) && data.achievementOtherTeacherIds.length != 0) {
    data.achievementOtherTeacherIds = data.achievementOtherTeacherIds.join(",")
  }
  const res = await listAchievement(data);
  achievementList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 查询成果类型 */
const getTypeList = async () => {
  const res = await listAchievementAvailable();
  types.value = res.data;
}

/** 根据名称获取用户信息 */
const getUserByNickName = async (nickname: string, type: string) => {
  if (nickname) {
    const res = await listByNickName(nickname);
    if (type === "student") {
      student.value = res.data
    } else if (type === "teacher") {
      teacher.value = res.data
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
  achievementFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: AchievementVO[]) => {
  ids.value = selection.map(item => item.achievementId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 修改按钮操作 */
const handleUpdate = (row?: AchievementVO) => {
  loading.value = true
  dialog.visible = true;
  dialog.title = "在校成果详情";
  nextTick(async () => {
    reset();
    const _achievementId = row?.achievementId || ids.value[0]
    const res = await getAchievement(_achievementId);
    loading.value = false;
    Object.assign(form.value, res.data);
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: AchievementVO) => {
  const _achievementIds = row?.achievementId || ids.value;
  await proxy?.$modal.confirm('是否确认删除在校成果管理编号为"' + _achievementIds + '"的数据项？').finally(() => loading.value = false);
  await delAchievement(_achievementIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('business/achievement/export', {
    ...queryParams.value
  }, `achievement_${new Date().getTime()}.xlsx`)
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
