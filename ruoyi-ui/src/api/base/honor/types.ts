export interface HonorVO {
  /**
   * 荣誉类型id
   */
  honorTypeId: string | number;

  /**
   * 荣誉类型名称
   */
  honorTypeName: string;

  /**
   * 荣誉类型状态（0正常 1停用）
   */
  status: string;

}

export interface HonorForm extends BaseEntity {
  /**
   * 荣誉类型id
   */
  honorTypeId?: string | number;

  /**
   * 荣誉类型名称
   */
  honorTypeName?: string;

  /**
   * 荣誉类型状态（0正常 1停用）
   */
  status?: string;

  /**
   * 备注
   */
  remark?: string;

}

export interface HonorQuery extends PageQuery {
  /**
   * 荣誉类型名称
   */
  honorTypeName?: string;

  /**
   * 荣誉类型状态（0正常 1停用）
   */
  status?: string;

}
