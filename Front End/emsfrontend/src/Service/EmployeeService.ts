import axios from 'axios';

const baseUrl="http://localhost:9090/api/employees;"

export const createEmployee = (employee:any) => axios.post(baseUrl,employee);

export const getAllEmployees = () => axios.get(baseUrl);

export const updateEmployee = (id:number,employee:any) => axios.put(baseUrl +"/"+id,employee);

export const deleteEmployeeById =(id:number) => axios.delete(baseUrl+"/"+id);

export const getEmployeeById=(id:number)=>axios.get(baseUrl+"/"+id);