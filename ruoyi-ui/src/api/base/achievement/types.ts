export interface AchievementVO {
  /**
   * 成果类型id
   */
  achievementTypeId: string | number;

  /**
   * 成果类型名称
   */
  achievementTypeName: string;

  /**
   * 成果类型状态（0正常 1停用）
   */
  status: string;

}

export interface AchievementForm extends BaseEntity {
  /**
   * 成果类型id
   */
  achievementTypeId?: string | number;

  /**
   * 成果类型名称
   */
  achievementTypeName?: string;

  /**
   * 成果类型状态（0正常 1停用）
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface AchievementQuery extends PageQuery {
  /**
   * 成果类型名称
   */
  achievementTypeName?: string;

  /**
   * 成果类型状态（0正常 1停用）
   */
  status?: string;

}
