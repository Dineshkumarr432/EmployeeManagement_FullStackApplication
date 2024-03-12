import { useEffect, useState } from "react";
import { getAllDepartments,deleteDepartment } from "../Service/DepartmentService";
import { Button, Table } from "react-bootstrap";
import { Link, useHistory } from "react-router-dom";

type Department={
    id:number;
    departmentName:string;
    departmentDescription:string;
}


const ListDepartment:React.FC=()=>{

  const history = useHistory();

    const [departments,setdepartments] = useState<Department[]>([])

    const updateDepartment = (id: number) => {
      history.push(`/edit-department/${id}`);
    };
    

    const listDepartments=()=>{
      getAllDepartments().
        then((response)=>{
            setdepartments(response.data)
        console.log(response.data);
        console.log(departments.length)
        })
        .catch((error)=>{
            console.log(error);
        })
    }

    const removeDepartment=(id:number)=>{
      deleteDepartment(id)
      .then(()=>listDepartments())
      .catch((error)=>console.log(error));
    }

    useEffect(()=>
      listDepartments() ,[])

    return(
        <>
        <Link to='/add-department' className='btn btn-primary mb-2'>Add Department</Link>
        <h1>List Of Departments</h1>
        <Table striped bordered hover>
      <thead>
        <tr>
          <th>Department ID</th>
          <th>Department Name</th>
          <th>Department Description</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
      { 
      departments.map(department=>
        <tr key={department.id}>
          <td>{department.id}</td>
          <td>{department.departmentName}</td>
          <td>{department.departmentDescription}</td>
          <td>
          <Button onClick={()=> updateDepartment(department.id)}variant="primary">Update</Button>{' '}
          <Button onClick={()=>removeDepartment(department.id)}variant="danger">Delete</Button>{' '}
          </td>
        </tr>
       )}
    
      </tbody>
    </Table>
        </>
    );
}

export default ListDepartment;