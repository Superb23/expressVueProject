import { storeToRefs } from 'pinia';
import useClientStore from '../../../front/src/stores/modules/client';
import useUserStore from '../../../front/src/stores/modules/user';
import useCourseStore from '../../../front/src/stores/modules/course';
import useCommonStore from '../../../front/src/stores/modules/common';


export const FRONT_CLASS = "前端课程";
export const BACK_CLASS = "后端课程";
export const ALL_CLASS = "全栈课程";
export const COMMON_USER = "普通用户";
export const VIP_USER = "会员用户";
export const SVIP_USER = "SVIP用户";
export const userCategory = [
  '普通用户',
  '会员用户',
  'SVIP用户'
];

export const TIP_MESSAGE = {
  FIRST_PAGE: "已经是第一页了",
  LAST_PAGE: "已经是最后一页了",
  STOP_DELETE_WHEN_START: "启用状态不能删除",
  NO_UPDATE_FORM: "没有发现更多内容"
}

export const pageSize = 5;
export const clientPageSize = 16;
export const clientCategory = [
  'common',
  'vip',
  'svip'
];

// 清理缓存utils
export const clearCacheUtil = () => {
  const clientStore = useClientStore();
  const { data, type } = storeToRefs(clientStore);

  const curPage = data.value.page;
  const list = data.value.list;
  for (let key in list) {
    if (key === type) {
      list[key].splice(curPage - 1);
    } else {
      list[key] = [];
    }
  }
}

// 清理store数据(退出登录)
export const clearStoreCache = () => {
  const courseStore = useCourseStore();
  const clientStore = useClientStore();
  const userStore = useUserStore();
  const commonStore = useCommonStore();
  courseStore.$reset();
  clientStore.$reset();
  userStore.$reset();
  commonStore.$reset();
}