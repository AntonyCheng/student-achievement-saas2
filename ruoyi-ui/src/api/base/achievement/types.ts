export interface AchievementVO {
  /**
   * 成果id
   */
  achievementId: string | number;

  /**
   * 成果名称
   */
  achievementName: string;

  /**
   * 成果状态（0正常 1停用）
   */
  status: string;

}

export interface AchievementForm extends BaseEntity {
  /**
   * 成果id
   */
  achievementId?: string | number;

  /**
   * 成果名称
   */
  achievementName?: string;

  /**
   * 成果状态（0正常 1停用）
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface AchievementQuery extends PageQuery {
  /**
   * 成果名称
   */
  achievementName?: string;

  /**
   * 成果状态（0正常 1停用）
   */
  status?: string;

}
