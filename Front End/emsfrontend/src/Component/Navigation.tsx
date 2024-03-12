import { Navbar, Container, Nav, NavDropdown } from "react-bootstrap";


const Navigation:React.FC=()=>{
    return(
        <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Home</Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link href="/listemployee">Employee</Nav.Link>
              <Nav.Link href="/listdepartment">Department</Nav.Link>
            </Nav>
        </Container>
      </Navbar>
    )
}

export default Navigation;