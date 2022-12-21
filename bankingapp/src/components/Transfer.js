import React, { useState } from "react";
import TransactionService from "../services/TransactionService";
import {Table} from 'react-bootstrap'

const Transfer = () => {

  const initialTransferState = {
    accountId: null,
    amount: null,
    errors: {}
  };

  const [transactionHistories, setTransactionHistories] = useState([]);
  const [transfer, setTransfer] = useState(initialTransferState);
  const [message, setMessage] = useState(false);
  const [submitted, setSubmitted] = useState(false);
  const [errors, setErrors] = useState([]);
  


  const handleInputChange = event => {
    const { name, value } = event.target;
    setTransfer({ ...transfer, [name]: value });
  };

  const submitTransfer = () => {
    var data = {
		    accountId: transfer.accountId,
        amount: transfer.amount
    };

    if (!validateForm(data)) {
      return false;
    }

    TransactionService.createTransaction(data)
      .then(response => {
        console.log(response.data);
        console.log(response.data.transactionHistories);
        setTransactionHistories(response.data.transactionHistories );
        setMessage(response.data.message );
	      setSubmitted(true);
        transfer.amount=null;
        transfer.accountId=null;
        document.getElementById("accountId").value="";
        document.getElementById("amount").value=null;
        setTransfer(transfer);
      })
      .catch(e => {
        console.log(e);
      });
  };
  const validateForm = (data) => {
    let errors = {}
    let formIsValid = true
    if (!data.accountId) {
          formIsValid = false
          errors['accountId'] = '*Please enter Account Id in UUID Format'
        }


    if(data.accountId){
     // Regular expression to check if string is a valid UUID
      const regexExp = /^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}$/gi;

      if (!regexExp.test(data.accountId)) {
        formIsValid = false
        errors['accountId'] = '*Please enter Account Id in UUID Format '
      }
            
    }

    if (!data.amount) {
      formIsValid = false
      errors['amount'] = '*Please enter your Amount'
    }
      
    setErrors(errors);
    return formIsValid;
}

  const newtransfer = () => {
    setTransfer(initialTransferState);
  };

  return (
    <div class="flex-container">

       <div class="flex-child1 magenta">
        <div className="form-group">
        <label htmlFor="accountId">Account Id</label>
            <input
              type="text"
              className="form-control"
              id="accountId"
              required
              value={transfer.accountId}
              onChange={handleInputChange}
              name="accountId"
              placeholder="Enter Account Id in UUID Format example: 0afd02d3-6c59-46e7-b7bc-893c5e0b7ac2" 
            />
			<div className='errorMsg'>{errors.accountId}</div>

        </div>
        <div className="form-group">
            <label htmlFor="amount">Amount</label>
            <input
              type="number"
              className="form-control"
              id="amount"
              required
              value={transfer.description}
              onChange={handleInputChange}
              name="amount"
              placeholder="Enter Amount Positive or Negative" 
            />
			<div className='errorMsg'>{errors.amount}</div>
          </div>

          <button onClick={submitTransfer} className="btn btn-success">
            Submit
          </button>
      </div>

      <div class="flex-child green">
      <div class="cell"> ´

{submitted ? (	
    <Table bordered hover striped variant="dark">
      <thead >
            <tr>
              <th colSpan={5}>Transaction Message</th>
            </tr>
          </thead>
          <tbody>
          <tr>
              <td colSpan={5}>{message}</td>
            </tr>
        </tbody>
        <thead >
            <tr>
              <th colSpan={5}>Transaction History</th>
            </tr>
          </thead>
          <thead >
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
            transactionHistories.length === 0 ?
            <tr align="center">
              <td colSpan="6">Transaction History</td>
            </tr> : 
            transactionHistories.map((transactionHistory) => (
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
): (
  <h1></h1>
)}

</div>
            

      </div>

  </div>
  );
};

export default Transfer;
