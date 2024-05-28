export interface AchievementVO {
  /**
   * 成果id
   */
  achievementId?: string | number;

  /**
   * 成果类型id
   */
  achievementTypeId?: string | number;

  /**
   * 成果类型
   */
  achievementTypeName?: string;

  /**
   * 成果名称
   */
  achievementName?: string;

  /**
   * 第一作者id
   */
  achievementStudentId?: string | number;

  /**
   * 第一作者
   */
  achievementStudentName?: string;

  /**
   * 第一作者所属部门id
   */
  achievementStudentDeptId?: string | number;

  /**
   * 第一作者所属部门
   */
  achievementStudentDeptName?: string;

  /**
   * 第一指导老师id
   */
  achievementTeacherId?: string | number;

  /**
   * 第一指导老师
   */
  achievementTeacherName?: string;

  /**
   * 其他成员id String
   */
  achievementOtherStudentIds?: string | number;

  /**
   * 其他成员
   */
  achievementOtherStudentNames?: string;

  /**
   * 其他老师id String
   */
  achievementOtherTeacherIds?: string | number;

  /**
   * 其他老师
   */
  achievementOtherTeacherNames?: string;

  /**
   * 佐证材料
   */
  achievementEvidenceUrl?: string | number;

  /**
   * 备注
   */
  remark?: string;
}

export interface AchievementForm extends BaseEntity {
  /**
   * 成果id
   */
  achievementId?: string | number;

  /**
   * 成果类型id
   */
  achievementTypeId?: string | number;

  /**
   * 成果类型
   */
  achievementTypeName?: string;

  /**
   * 成果名称
   */
  achievementName?: string;

  /**
   * 第一作者id
   */
  achievementStudentId?: string | number;

  /**
   * 第一作者
   */
  achievementStudentName?: string;

  /**
   * 第一作者所属部门id
   */
  achievementStudentDeptId?: string | number;

  /**
   * 第一作者所属部门
   */
  achievementStudentDeptName?: string;

  /**
   * 第一指导老师id
   */
  achievementTeacherId?: string | number;

  /**
   * 第一指导老师
   */
  achievementTeacherName?: string;

  /**
   * 其他成员id String
   */
  achievementOtherStudentIds?: string | number;

  /**
   * 其他成员
   */
  achievementOtherStudentNames?: string;

  /**
   * 其他老师id String
   */
  achievementOtherTeacherIds?: string | number;

  /**
   * 其他老师
   */
  achievementOtherTeacherNames?: string;

  /**
   * 佐证材料
   */
  achievementEvidenceUrl?: string | number;

  /**
   * 备注
   */
  remark?: string;
}

export interface AchievementQuery extends PageQuery {
  /**
   * 成果类型
   */
  achievementTypeId?: string | number;

  /**
   * 成果名称
   */
  achievementName?: string;

  /**
   * 第一作者
   */
  achievementStudentId?: string | number;

  /**
   * 第一作者所属部门
   */
  achievementStudentDeptId?: string | number;

  /**
   * 第一指导老师
   */
  achievementTeacherId?: string | number;

  /**
   * 其他成员
   */
  achievementOtherStudentIds?: string | number;

  /**
   * 其他老师
   */
  achievementOtherTeacherIds?: string | number;

  /**
   * 成果状态（0待审核 1审核通过 2审核不通过）
   */
  status?: string;
}
