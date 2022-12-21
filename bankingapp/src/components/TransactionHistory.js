import React, { Component } from 'react'
import TransactionService from "../services/TransactionService";

import {Card, Table} from 'react-bootstrap'

export default class TransactionHistory extends Component {

	constructor(props){
		super(props);
		this.state = {
			transactionHistories: []
		};
	}

	componentDidMount(){
		TransactionService.getAllTransactions()
    	.then(response => response.data)
		.then((data) => {
			this.setState({transactionHistories: data});
		});
	}

	render () {
		return (
			<Card className={"border border-dark bg-dark text-white"}>
				<Card.Header>Transaction History</Card.Header>
				<Card.Body>
					<Table bordered hover striped variant="dark">
				    	<thead>
						    <tr>
						      <th>Transaction Id</th>
						      <th>Account Id</th>
							  <th>Amount</th>
							  <th>Transaction Type</th>
							  <th>Transaction Date</th>
						    </tr>
					  	</thead>
					  	<tbody>
						  {
						  	this.state.transactionHistories.length === 0 ?
						  	<tr align="center">
						    	<td colSpan="6">Transaction History</td>
						    </tr> : 
						    this.state.transactionHistories.map((transactionHistory) => (
						    <tr key={transactionHistory.id}>
								<td>{transactionHistory.id}</td>
					    		<td>{transactionHistory.accountId}</td>
					    		<td>{transactionHistory.amount}</td>
								<td>{transactionHistory.transactionType}</td>
								<td>{transactionHistory.transactionDate}</td>
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