export interface HonorVO {
  /**
   * 荣誉id
   */
  honorId: string | number;

  /**
   * 荣誉名称
   */
  honorName: string;

  /**
   * 荣誉状态（0正常 1停用）
   */
  status: string;

}

export interface HonorForm extends BaseEntity {
  /**
   * 荣誉id
   */
  honorId?: string | number;

  /**
   * 荣誉名称
   */
  honorName?: string;

  /**
   * 荣誉状态（0正常 1停用）
   */
  status?: string;

}

export interface HonorQuery extends PageQuery {
  /**
   * 荣誉名称
   */
  honorName?: string;

  /**
   * 荣誉状态（0正常 1停用）
   */
  status?: string;

}
