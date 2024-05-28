import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AchievementVO, AchievementForm, AchievementQuery } from '@/api/business/myAchievement/types';

/**
 * 查询在校成果管理列表
 * @param query
 * @returns {*}
 */
export const listAchievement = (query?: AchievementQuery): AxiosPromise<AchievementVO[]> => {
  return request({
    url: '/business/achievement/my/list',
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
    url: '/business/achievement/my/' + achievementId,
    method: 'get'
  });
};

/**
 * 新增在校成果管理
 * @param data
 */
export const addAchievement = (data: AchievementForm) => {
  return request({
    url: '/business/achievement/my',
    method: 'post',
    data: data
  });
};

/**
 * 修改在校成果管理
 * @param data
 */
export const updateAchievement = (data: AchievementForm) => {
  return request({
    url: '/business/achievement/my',
    method: 'put',
    data: data
  });
};

/**
 * 删除在校成果管理
 * @param achievementId
 */
export const delAchievement = (achievementId: string | number | Array<string | number>) => {
  return request({
    url: '/business/achievement/my/' + achievementId,
    method: 'delete'
  });
};

/**
 * 佐证材料上传
 * @param data
 */
export const uploadFile = (data: FormData) => {
  return request({
    url: '/business/achievement/my/file',
    method: 'post',
    data: data
  });
};
