import React from 'react';
import Navigation from './Component/Navigation';
import { Route, Switch } from 'react-router-dom';
import ListDepartment from './Component/ListDepartment';
import ListEmployee from './Component/ListEmployee';
import Department from './Component/Department';
import Employee from './Component/Employee';

const Home=()=>{
  return(
    <>
    <h1>Employee Management System</h1>
    </>
  )
}
function App() {
  return (
  <>
  <Navigation/>
  <Switch>
    <Route exact path = "/"><Home/></Route>
    <Route exact path = "/listdepartment"><ListDepartment/></Route>
    <Route exact path = "/listemployee"><ListEmployee/></Route>
    <Route exact path = "/edit-department/:id"><Department/></Route>
    <Route exact path = "/departments"><ListDepartment/></Route>
    <Route exact path = "/add-department"><Department/></Route>
    <Route exact path = "/add-employee"><Employee/></Route>
    <Route exact path = "/edit-employee/:id"><Employee/></Route>
    <Route exact path = "/employee"><ListEmployee/></Route>
  </Switch>
  </>
  );
}

export default App;
