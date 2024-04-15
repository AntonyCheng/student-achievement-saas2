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
 * 查询成果类型详细
 * @param achievementId
 */
export const getAchievement = (achievementId: string | number): AxiosPromise<AchievementVO> => {
  return request({
    url: '/base/achievement/' + achievementId,
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
 * @param achievementId
 */
export const delAchievement = (achievementId: string | number | Array<string | number>) => {
  return request({
    url: '/base/achievement/' + achievementId,
    method: 'delete'
  });
};
