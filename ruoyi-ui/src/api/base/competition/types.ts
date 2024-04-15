export interface CompetitionVO {
  /**
   * 竞赛id
   */
  competitionId: string | number;

  /**
   * 竞赛名称
   */
  competitionName: string;

  /**
   * 竞赛状态（0正常 1停用）
   */
  status: string;

}

export interface CompetitionForm extends BaseEntity {
  /**
   * 竞赛id
   */
  competitionId?: string | number;

  /**
   * 竞赛名称
   */
  competitionName?: string;

  /**
   * 竞赛状态（0正常 1停用）
   */
  status?: string;

}

export interface CompetitionQuery extends PageQuery {
  /**
   * 竞赛名称
   */
  competitionName?: string;

  /**
   * 竞赛状态（0正常 1停用）
   */
  status?: string;

}
