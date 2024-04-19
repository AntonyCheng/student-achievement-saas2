export interface CompetitionVO {
  /**
   * 竞赛类型id
   */
  competitionTypeId: string | number;

  /**
   * 竞赛类型名称
   */
  competitionTypeName: string;

  /**
   * 竞赛类型状态（0正常 1停用）
   */
  status: string;

}

export interface CompetitionForm extends BaseEntity {
  /**
   * 竞赛类型id
   */
  competitionTypeId?: string | number;

  /**
   * 竞赛类型名称
   */
  competitionTypeName?: string;

  /**
   * 竞赛类型状态（0正常 1停用）
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface CompetitionQuery extends PageQuery {
  /**
   * 竞赛类型名称
   */
  competitionTypeName?: string;

  /**
   * 竞赛类型状态（0正常 1停用）
   */
  status?: string;

}
