import request from '@/utils/request'

// 查询学生表单上传列表
export function listStudent(query) {
  return request({
    url: '/student/student/list',
    method: 'get',
    params: query
  })
}

// 查询学生表单上传详细
export function getStudent(stuId) {
  return request({
    url: '/student/student/' + stuId,
    method: 'get'
  })
}

// 新增学生表单上传
export function addStudent(data) {
  return request({
    url: '/student/student',
    method: 'post',
    data: data
  })
}

// 修改学生表单上传
export function updateStudent(data) {
  return request({
    url: '/student/student',
    method: 'put',
    data: data
  })
}

// 删除学生表单上传
export function delStudent(stuId) {
  return request({
    url: '/student/student/' + stuId,
    method: 'delete'
  })
}
