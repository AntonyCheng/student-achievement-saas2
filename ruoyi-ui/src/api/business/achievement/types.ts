export interface AchievementVO {
  /**
   * 成果id
   */
  achievementId: string | number;

  /**
   * 成果类型id
   */
  achievementTypeId: string | number;

  /**
   * 成果第一作者id
   */
  achievementStudentId: string | number;

  /**
   * 成果第一指导老师id
   */
  achievementTeacherId: string | number;

  /**
   * 成果其他作者id JSON
   */
  achievementOtherStudentIds: string | number;

  /**
   * 成果其他指导老师id JSON
   */
  achievementOtherTeacherIds: string | number;

  /**
   * 成果作证材料URL
   */
  achievementEvidenceUrl: string | number;

  /**
   * 备注
   */
  remark: string;

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
   * 成果第一作者id
   */
  achievementStudentId?: string | number;

  /**
   * 成果第一指导老师id
   */
  achievementTeacherId?: string | number;

  /**
   * 成果其他作者id JSON
   */
  achievementOtherStudentIds?: string | number;

  /**
   * 成果其他指导老师id JSON
   */
  achievementOtherTeacherIds?: string | number;

  /**
   * 成果作证材料URL
   */
  achievementEvidenceUrl?: string | number;

  /**
   * 备注
   */
  remark?: string;

}

export interface AchievementQuery extends PageQuery {
  /**
   * 成果类型id
   */
  achievementTypeId?: string | number;

  /**
   * 成果第一作者id
   */
  achievementStudentId?: string | number;

  /**
   * 成果第一指导老师id
   */
  achievementTeacherId?: string | number;

  /**
   * 成果其他作者id JSON
   */
  achievementOtherStudentIds?: string | number;

  /**
   * 成果其他指导老师id JSON
   */
  achievementOtherTeacherIds?: string | number;

  /**
   * 成果作证材料URL
   */
  achievementEvidenceUrl?: string | number;

  /**
   * 成果审核反馈
   */
  achievementFeedback?: string;

  /**
   * 成果状态（0待审核 1审核通过 2审核不通过）
   */
  status?: string;

}
