import React, { Component } from 'react'
import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';

export default class NavigationBar extends Component {
    render() {
        return (
            <Navbar bg="dark" variant="dark">
            	<Link to={""} className="navbar-brand">
            		<img
				        alt=""
				        src="/bank.png"
				        width="30"
				        height="30"
				        className="d-inline-block align-top"
			        />{' '}
            	</Link>
			    <Nav className="mr-auto">
					<Link to={"Transfer"} className="nav-link">Transfer</Link>
				    <Link to={"TransactionHistory"} className="nav-link">Transaction History</Link>
				    <Link to={"Accountslist"} className="nav-link">Show Accounts</Link>
			    </Nav>
		  	</Navbar>
    	);
    }

}