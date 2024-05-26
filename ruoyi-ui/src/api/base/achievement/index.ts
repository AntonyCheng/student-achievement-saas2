import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AchievementVO, AchievementForm, AchievementQuery } from '@/api/base/achievement/types';

/**
 * 查询成果类型列表
 * @param query
 * @returns {*}
 */

export const listAchievement = (query?: AchievementQuery): AxiosPromise<AchievementVO[]> => {
  return request({
    url: '/base/achievement/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询有效成果类型列表
 */
export const listAchievementAvailable = () => {
  return request({
    url: '/base/achievement/list/available',
    method: 'get'
  });
};

/**
 * 查询成果类型详细
 * @param achievementTypeId
 */
export const getAchievement = (achievementTypeId: string | number): AxiosPromise<AchievementVO> => {
  return request({
    url: '/base/achievement/' + achievementTypeId,
    method: 'get'
  });
};

/**
 * 新增成果类型
 * @param data
 */
export const addAchievement = (data: AchievementForm) => {
  return request({
    url: '/base/achievement',
    method: 'post',
    data: data
  });
};

/**
 * 修改成果类型
 * @param data
 */
export const updateAchievement = (data: AchievementForm) => {
  return request({
    url: '/base/achievement',
    method: 'put',
    data: data
  });
};

/**
 * 删除成果类型
 * @param achievementTypeId
 */
export const delAchievement = (achievementTypeId: string | number | Array<string | number>) => {
  return request({
    url: '/base/achievement/' + achievementTypeId,
    method: 'delete'
  });
};
