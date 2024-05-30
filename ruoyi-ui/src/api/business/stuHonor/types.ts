export interface HonorVO {
  /**
   * 荣誉id
   */
  honorId?: string | number;

  /**
   * 荣誉类型id
   */
  honorTypeId?: string | number;

  /**
   * 荣誉类型
   */
  honorTypeName?: string;

  /**
   * 荣誉名称
   */
  honorName?: string;

  /**
   * 第一作者id
   */
  honorStudentId?: string | number;

  /**
   * 第一作者
   */
  honorStudentName?: string;

  /**
   * 第一作者所属部门id
   */
  honorStudentDeptId?: string | number;

  /**
   * 第一作者所属部门
   */
  honorStudentDeptName?: string;

  /**
   * 第一指导老师id
   */
  honorTeacherId?: string | number;

  /**
   * 第一指导老师
   */
  honorTeacherName?: string;

  /**
   * 其他成员id String
   */
  honorOtherStudentIds?: string | number;

  /**
   * 其他成员
   */
  honorOtherStudentNames?: string;

  /**
   * 其他老师id String
   */
  honorOtherTeacherIds?: string | number;

  /**
   * 其他老师
   */
  honorOtherTeacherNames?: string;

  /**
   * 佐证材料
   */
  honorEvidenceUrl?: string | number;

  /**
   * 备注
   */
  remark?: string;
}

export interface HonorForm extends BaseEntity {
  /**
   * 荣誉id
   */
  honorId?: string | number;

  /**
   * 荣誉类型id
   */
  honorTypeId?: string | number;

  /**
   * 荣誉类型
   */
  honorTypeName?: string;

  /**
   * 荣誉名称
   */
  honorName?: string;

  /**
   * 第一作者id
   */
  honorStudentId?: string | number;

  /**
   * 第一作者
   */
  honorStudentName?: string;

  /**
   * 第一作者所属部门id
   */
  honorStudentDeptId?: string | number;

  /**
   * 第一作者所属部门
   */
  honorStudentDeptName?: string;

  /**
   * 第一指导老师id
   */
  honorTeacherId?: string | number;

  /**
   * 第一指导老师
   */
  honorTeacherName?: string;

  /**
   * 其他成员id String
   */
  honorOtherStudentIds?: string | number;

  /**
   * 其他成员
   */
  honorOtherStudentNames?: string;

  /**
   * 其他老师id String
   */
  honorOtherTeacherIds?: string | number;

  /**
   * 其他老师
   */
  honorOtherTeacherNames?: string;

  /**
   * 佐证材料
   */
  honorEvidenceUrl?: string | number;

  /**
   * 审核反馈
   */
  honorFeedback?: string;

  /**
   * 荣誉状态（0待审核 1审核通过 2审核不通过）
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;
}

export interface HonorQuery extends PageQuery {
  /**
   * 荣誉类型
   */
  honorTypeId?: string | number;

  /**
   * 荣誉名称
   */
  honorName?: string;

  /**
   * 第一作者
   */
  honorStudentId?: string | number;

  /**
   * 第一作者所属部门
   */
  honorStudentDeptId?: string | number;

  /**
   * 第一指导老师
   */
  honorTeacherId?: string | number;

  /**
   * 其他成员
   */
  honorOtherStudentIds?: string | number;

  /**
   * 其他老师
   */
  honorOtherTeacherIds?: string | number;

  /**
   * 荣誉状态（0待审核 1审核通过 2审核不通过）
   */
  status?: string;
}
