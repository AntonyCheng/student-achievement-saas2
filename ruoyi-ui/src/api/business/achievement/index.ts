import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AchievementVO, AchievementForm, AchievementQuery } from '@/api/business/achievement/types';

/**
 * 查询在校成果管理列表
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
 * 查询在校成果管理详细
 * @param achievementId
 */
export const getAchievement = (achievementId: string | number): AxiosPromise<AchievementVO> => {
  return request({
    url: '/business/achievement/' + achievementId,
    method: 'get'
  });
};

/**
 * 删除在校成果管理
 * @param achievementId
 */
export const delAchievement = (achievementId: string | number | Array<string | number>) => {
  return request({
    url: '/business/achievement/' + achievementId,
    method: 'delete'
  });
};
