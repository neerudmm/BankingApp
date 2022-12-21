import React, { Component } from 'react'

import {Card, Table} from 'react-bootstrap'
import TransactionService from "../services/TransactionService";


export default class Accountslist extends Component {

	constructor(props){
		super(props);
		this.state = {
			accounts: []
		};
	}

	componentDidMount(){
		TransactionService.getAllAccounts()
    	.then(response => response.data)
		.then((data) => {
			this.setState({accounts: data});
		});
	}

	render () {
		return (
			<Card className={"border border-dark bg-dark text-white"}>
				<Card.Header>Accounts List</Card.Header>
				<Card.Body>
					<Table bordered hover striped variant="dark">
				    	<thead>
						    <tr>
						      <th>Account ID</th>
						      <th>Balance</th>
						    </tr>
					  	</thead>
					  	<tbody>
						  {
						  	this.state.accounts.length === 0 ?
						  	<tr align="center">
						    	<td colSpan="6">No Accounts Present.</td>
						    </tr> : 
						    this.state.accounts.map((account) => (
						    <tr key={account.accountId}>
					    		<td>{account.accountId}</td>
					    		<td>{account.balance}</td>
					    	</tr>
						    ))
						    
						  }
					  	</tbody>
					</Table>
				</Card.Body>
			</Card>
		);
	}
}