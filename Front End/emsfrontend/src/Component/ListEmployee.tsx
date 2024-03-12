import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { deleteEmployeeById, getAllEmployees } from "../Service/EmployeeService";
import { useHistory } from "react-router-dom";

type Employee={
    id:number;
    firstName:string;
    lastName:string;
    email:string;
}

const ListEmployee:React.FC=()=>{
    const[employees,setEmployees] = useState<Employee[]>([]);

    const history = useHistory();

    const addNewEmployee=()=>{
        history.push(`/add-employee`)
    }    

    const updateEmployee=(id:number)=>{
        history.push(`edit-employee/${id}`)
    }

    const removeEmployee=(id:number)=>{
        deleteEmployeeById(id).
        then(()=>getAllEmployees().then((response)=>{setEmployees(response.data);}).catch((error)=>console.log(error))
        )
        .catch((error)=>console.log(error));
    }


    useEffect(()=>{
        getAllEmployees().then((response)=>{
            setEmployees(response.data);
        })
        .catch((error)=>console.log(error));
    },[]);


    return(
        <>
        
        <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
        <Table striped bordered hover>
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Department Name</th>
          </tr>
        </thead>
        <tbody>
            {
                employees.map((employee)=>
          <tr>
            <td>{employee.id}</td>
            <td >{employee.firstName}</td>
            <td>{employee.lastName}</td>
            <td>{employee.email}</td>
            <td><button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button>
<button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}
style={{marginLeft: '10px'}}
>Delete</button>
</td>
          </tr>)
}
        </tbody>
      </Table>
      </>
    );
}

export default ListEmployee;