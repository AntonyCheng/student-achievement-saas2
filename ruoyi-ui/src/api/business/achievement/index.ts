import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AchievementVO, AchievementForm, AchievementQuery } from '@/api/business/achievement/types';

/**
 * 查询成果列表
 * @param query
 * @returns {*}
 */

export const listAchievement = (query?: AchievementQuery): AxiosPromise<AchievementVO[]> => {
  return request({
    url: '/business/achievement/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询成果详细
 * @param achievementId
 */
export const getAchievement = (achievementId: string | number): AxiosPromise<AchievementVO> => {
  return request({
    url: '/business/achievement/' + achievementId,
    method: 'get'
  });
};

/**
 * 新增成果
 * @param data
 */
export const addAchievement = (data: AchievementForm) => {
  return request({
    url: '/business/achievement',
    method: 'post',
    data: data
  });
};

/**
 * 修改成果
 * @param data
 */
export const updateAchievement = (data: AchievementForm) => {
  return request({
    url: '/business/achievement',
    method: 'put',
    data: data
  });
};

/**
 * 删除成果
 * @param achievementId
 */
export const delAchievement = (achievementId: string | number | Array<string | number>) => {
  return request({
    url: '/business/achievement/' + achievementId,
    method: 'delete'
  });
};
