import axios from 'axios';

const getAllAccounts = (params) => {
  return axios.get("http://localhost:5000/accounts", { params });
};

const getAllTransactions = (params) => {
  return axios.get("http://localhost:5000/transactions", { params });
};

const createTransaction = data => {
  return axios.post("http://localhost:5000/transactions", data);
};

export default {
  getAllAccounts,
  getAllTransactions,
  createTransaction
};
