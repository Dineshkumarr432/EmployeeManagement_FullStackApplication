import { FormEvent, useEffect, useState } from "react";
import { Button, Col, Container, Form, Row } from "react-bootstrap";
import { useHistory, useParams } from "react-router-dom";
import { createDepartment, getDepartmentById, updateDepartment } from "../Service/DepartmentService";

type RouteParam={
    id:string;
}

const Department:React.FC=()=>{

    const history=useHistory();

    const {id}=useParams<RouteParam>();

    const [departmentName,setDepartmentName]=useState<string>();

    const [departmentDescription,setDepartmentDescription]=useState<string>();

    const saveOrUpdate=(e:FormEvent)=>{
        e.preventDefault();
        const department={departmentName,departmentDescription}
        if(id){
            updateDepartment(Number(id),department).then((response)=>history.push(`/departments`))
            .catch((error)=>console.log(error))
        }
        else{
            createDepartment(department).then(()=>history.push(`department`))
            .catch((error)=>console.log(error));
        }
    }

    useEffect(()=>{
        if(id){
        getDepartmentById(Number(id)).then((response)=>{setDepartmentName(response.data.departmentName);
        setDepartmentDescription(response.data.departmentDescription)})
        }
    },[id]
    )
    

    return(
        <Container>
            <Row>
                <Col>
                <Form>
                <Form.Label>Department Name</Form.Label>
      <Form.Control
        type="text"
        placeholder="Enter Department Name" value={departmentName} onChange={(e)=>setDepartmentName(e.target.value)}
      />

<Form.Label>Department Description</Form.Label>
      <Form.Control
        type="text"
         placeholder="Enter Department Description" value={departmentDescription}
         onChange={(e)=>setDepartmentDescription(e.target.value)}
      />

     
    </Form>
    </Col>
    </Row>
    <Button onClick={(e)=>saveOrUpdate(e)}variant="primary">Submit</Button>{' '}
    </Container>
    );
}

export default Department;