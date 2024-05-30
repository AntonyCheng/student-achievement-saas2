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
          <el-form-item label="指导老师" prop="honorTeacherId">
            <el-select
              v-model="queryParams.honorTeacherId"
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['business:myHonor:add']"> 新增 </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['business:myHonor:edit']"
              >修改
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['business:myHonor:remove']"
              >删除
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['business:myHonor:export']">导出 </el-button>
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
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['business:myHonor:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['business:myHonor:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total>0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改在校荣誉管理对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="honorFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="荣誉类型" prop="honorTypeId">
          <el-select v-model="form.honorTypeId" placeholder="请选择荣誉类型" clearable style="width: 100%;">
            <el-option v-for="dict in types" :key="dict.honorTypeId" :label="dict.honorTypeName" :value="dict.honorTypeId" />
          </el-select>
        </el-form-item>
        <el-form-item label="荣誉名称" prop="honorName">
          <el-input v-model="form.honorName" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="指导老师" prop="honorTeacherId">
          <el-select
            v-model="form.honorTeacherId"
            clearable
            filterable
            remote
            reserve-keyword
            placeholder="请搜索第一指导老师"
            :remote-method="(query) => getUserByNickName(query,'teacherAddEdit')"
            :loading="loading"
            style="width: 100%"
          >
            <el-option v-for="item in teacherAddEdit" :key="item.userId" :label="item.nickName" :value="item.userId">
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
            v-model="form.honorOtherStudentIds"
            clearable
            multiple
            filterable
            remote
            reserve-keyword
            placeholder="请搜索其他成员"
            :multiple-limit="20"
            :remote-method="(query) => getUserByNickName(query,'membersAddEdit')"
            :loading="loading"
            style="width: 100%"
          >
            <el-option v-for="item in membersAddEdit" :key="item.userId" :label="item.nickName" :value="item.userId">
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
            v-model="form.honorOtherTeacherIds"
            clearable
            multiple
            filterable
            remote
            reserve-keyword
            placeholder="请搜索其他老师"
            :multiple-limit="20"
            :remote-method="(query) => getUserByNickName(query,'teachersAddEdit')"
            :loading="loading"
            style="width: 100%"
          >
            <el-option v-for="item in teachersAddEdit" :key="item.userId" :label="item.nickName" :value="item.userId">
              <span style="float: left">{{ item.nickName }}</span>
              <el-divider direction="vertical" />
              <span style="float: right;color: var(--el-text-color-secondary);font-size: 13px;">
                {{ item.deptName }}
              </span>
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="佐证材料" prop="honorEvidenceUrl">
          <el-upload
            ref="upload"
            :http-request="handleUploadFile"
            :before-upload="beforeUpload"
            :file-list="fileList"
            :limit="1"
            :on-exceed="handleExceed"
            class="upload-demo"
            drag
          >
            <el-icon class="el-icon--upload">
              <upload-filled />
            </el-icon>
            <div class="el-upload__text" style="width: 240px;"><em>点击或者拖拽上传</em></div>
            <template #tip>
              <div class="el-upload__tip">文件大小不超过50MB</div>
            </template>
          </el-upload>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
  delHonor,
  addHonor,
  updateHonor,
  uploadFile
} from '@/api/business/myHonor';
import {HonorVO, HonorQuery, HonorForm} from '@/api/business/myHonor/types';
import {listHonorAvailable} from "@/api/base/honor";
import {HonorVO as HonorTypeVO} from "@/api/base/honor/types";
import {UserByNickName} from "@/api/system/user/types";
import {listByNickName} from "@/api/system/user";
import {
  genFileId,
  UploadInstance,
  UploadProps,
  UploadRawFile,
  UploadRequestOptions, UploadUserFile,
} from "element-plus";

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
const members = ref<UserByNickName[]>([]);
const teacher = ref<UserByNickName[]>([]);
const teachers = ref<UserByNickName[]>([]);
const membersAddEdit = ref<UserByNickName[]>([]);
const teacherAddEdit = ref<UserByNickName[]>([]);
const teachersAddEdit = ref<UserByNickName[]>([]);
const fileList = ref<UploadUserFile[]>([])

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
  remark: undefined
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
    honorTypeId: [
      {required: true, message: "荣誉类型不能为空", trigger: "blur"}
    ],
    honorName: [
      {required: true, message: "荣誉名称不能为空", trigger: "blur"}
    ],
    honorTeacherId: [
      {required: true, message: "第一指导老师不能为空", trigger: "blur"}
    ],
    honorEvidenceUrl: [
      {required: true, message: "佐证材料不能为空", trigger: "blur"}
    ],
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
    if (type === "members") {
      members.value = res.data
    } else if (type === "teacher") {
      teacher.value = res.data
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

/** 新增按钮操作 */
const handleAdd = () => {
  dialog.visible = true;
  dialog.title = "添加在校荣誉管理";
  fileList.value = []
  nextTick(() => {
    reset();
  });
}

/** 修改按钮操作 */
const handleUpdate = (row?: HonorVO) => {
  loading.value = true
  dialog.visible = true;
  dialog.title = "修改在校荣誉管理";
  fileList.value = []
  nextTick(async () => {
    reset();
    const _honorId = row?.honorId || ids.value[0]
    const res = await getHonor(_honorId);
    res.data.honorOtherTeacherIds = '';
    res.data.honorOtherStudentIds = '';
    res.data.honorTeacherId = '';
    res.data.honorEvidenceUrl = '';
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
      } else {
        await addHonor(data).finally(() => buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("修改成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: HonorVO) => {
  const _honorIds = row?.honorId || ids.value;
  await proxy?.$modal.confirm('是否确认删除在校荣誉管理编号为"' + _honorIds + '"的数据项？').finally(() => loading.value = false);
  await delHonor(_honorIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('business/honor/my/export', {
    ...queryParams.value
  }, `honor_${new Date().getTime()}.xlsx`)
}

/** 上传操作 */
const handleUploadFile = async (options: UploadRequestOptions) => {
  const formData = new FormData()
  formData.append("file", options.file, options.filename);
  const url = await uploadFile(formData)
  form.value.honorEvidenceUrl = url.msg
}

/** 上传预处理 */
const beforeUpload = (rawFile: UploadRawFile) => {
  const size = rawFile.size / 1024 / 1024
  if (size > 50) {
    proxy?.$modal.msgError("大小不能超过50MB");
    return false;
  }
};

const upload = ref<UploadInstance>()
const handleExceed: UploadProps['onExceed'] = (files) => {
  upload.value?.clearFiles()
  const file = files[0] as UploadRawFile
  file.uid = genFileId()
  upload.value?.handleStart(file)
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
