export interface CompetitionVO {
  /**
   * 竞赛id
   */
  competitionId?: string | number;

  /**
   * 竞赛类型id
   */
  competitionTypeId?: string | number;

  /**
   * 竞赛类型
   */
  competitionTypeName?: string;

  /**
   * 竞赛名称
   */
  competitionName?: string;

  /**
   * 第一作者id
   */
  competitionStudentId?: string | number;

  /**
   * 第一作者
   */
  competitionStudentName?: string;

  /**
   * 第一作者所属部门id
   */
  competitionStudentDeptId?: string | number;

  /**
   * 第一作者所属部门
   */
  competitionStudentDeptName?: string;

  /**
   * 第一指导老师id
   */
  competitionTeacherId?: string | number;

  /**
   * 第一指导老师
   */
  competitionTeacherName?: string;

  /**
   * 其他成员id String
   */
  competitionOtherStudentIds?: string | number;

  /**
   * 其他成员
   */
  competitionOtherStudentNames?: string;

  /**
   * 其他老师id String
   */
  competitionOtherTeacherIds?: string | number;

  /**
   * 其他老师
   */
  competitionOtherTeacherNames?: string;

  /**
   * 佐证材料
   */
  competitionEvidenceUrl?: string | number;

  /**
   * 备注
   */
  remark?: string;
}

export interface CompetitionForm extends BaseEntity {
  /**
   * 竞赛id
   */
  competitionId?: string | number;

  /**
   * 竞赛类型id
   */
  competitionTypeId?: string | number;

  /**
   * 竞赛类型
   */
  competitionTypeName?: string;

  /**
   * 竞赛名称
   */
  competitionName?: string;

  /**
   * 第一作者id
   */
  competitionStudentId?: string | number;

  /**
   * 第一作者
   */
  competitionStudentName?: string;

  /**
   * 第一作者所属部门id
   */
  competitionStudentDeptId?: string | number;

  /**
   * 第一作者所属部门
   */
  competitionStudentDeptName?: string;

  /**
   * 第一指导老师id
   */
  competitionTeacherId?: string | number;

  /**
   * 第一指导老师
   */
  competitionTeacherName?: string;

  /**
   * 其他成员id String
   */
  competitionOtherStudentIds?: string | number;

  /**
   * 其他成员
   */
  competitionOtherStudentNames?: string;

  /**
   * 其他老师id String
   */
  competitionOtherTeacherIds?: string | number;

  /**
   * 其他老师
   */
  competitionOtherTeacherNames?: string;

  /**
   * 佐证材料
   */
  competitionEvidenceUrl?: string | number;

  /**
   * 备注
   */
  remark?: string;
}

export interface CompetitionQuery extends PageQuery {
  /**
   * 竞赛类型
   */
  competitionTypeId?: string | number;

  /**
   * 竞赛名称
   */
  competitionName?: string;

  /**
   * 第一作者
   */
  competitionStudentId?: string | number;

  /**
   * 第一作者所属部门
   */
  competitionStudentDeptId?: string | number;

  /**
   * 第一指导老师
   */
  competitionTeacherId?: string | number;

  /**
   * 其他成员
   */
  competitionOtherStudentIds?: string | number;

  /**
   * 其他老师
   */
  competitionOtherTeacherIds?: string | number;

  /**
   * 竞赛状态（0待审核 1审核通过 2审核不通过）
   */
  status?: string;
}
