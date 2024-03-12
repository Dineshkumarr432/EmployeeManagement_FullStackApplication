import axios from 'axios';

const baseUrl="http://localhost:9090/api/departments";

export const createDepartment = (department:any) => axios.post(baseUrl,department);

export const getAllDepartments = () => axios.get(baseUrl);

export const updateDepartment=(departmentId:number,department:any)=>axios.put(baseUrl+'/'+departmentId,department);

export const getDepartmentById = (departmentId: number) => axios.get(baseUrl + '/' + departmentId);


export const deleteDepartment = (departmentId: number) => axios.delete(baseUrl + '/' + departmentId);