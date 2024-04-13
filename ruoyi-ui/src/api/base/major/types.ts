export interface MajorVO {
  /**
   * 专业id
   */
  majorId: string | number;

  /**
   * 部门id
   */
  deptId: string | number;

  /**
   * 专业名称
   */
  majorName: string;

  /**
   * 专业年级
   */
  majorGrade: string;

  /**
   * 专业状态（0正常 1停用）
   */
  status: string;

}

export interface MajorForm extends BaseEntity {
  /**
   * 专业id
   */
  majorId?: string | number;

  /**
   * 部门id
   */
  deptId?: string | number;

  /**
   * 专业名称
   */
  majorName?: string;

  /**
   * 专业年级
   */
  majorGrade?: string;

  /**
   * 专业状态（0正常 1停用）
   */
  status?: string;

}

export interface MajorQuery extends PageQuery {
  /**
   * 部门id
   */
  deptId?: string | number;

  /**
   * 专业名称
   */
  majorName?: string;

  /**
   * 专业年级
   */
  majorGrade?: string;

  /**
   * 专业状态（0正常 1停用）
   */
  status?: string;

}
