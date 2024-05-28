import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AchievementVO, AchievementForm, AchievementQuery } from '@/api/business/stuAchievement/types';

/**
 * 查询在校成果管理列表
 * @param query
 * @returns {*}
 */
export const listAchievement = (query?: AchievementQuery): AxiosPromise<AchievementVO[]> => {
  return request({
    url: '/business/achievement/stu/list',
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
    url: '/business/achievement/stu/' + achievementId,
    method: 'get'
  });
};

/**
 * 修改在校成果管理
 * @param data
 */
export const updateAchievement = (data: AchievementForm) => {
  return request({
    url: '/business/achievement/stu',
    method: 'put',
    data: data
  });
};
