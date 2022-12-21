import React from 'react';
import './App.css';
import './css/bank.css';
import './index.css';

import {Container, Row, Jumbotron, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import Accountslist from './components/Accountslist';
import TransactionHistory from './components/TransactionHistory';
import Transfer from './components/Transfer';

function App() {
  const marginTop = {
  	marginTop:"20px"
  }
  return (
	
    <Router className="App">
    	<NavigationBar/>
    	<Container>
    		<Col lg={12} style={marginTop}>
    			<Switch>
    				<Route path="/" exact component={Welcome}/>
    				<Route path="/Accountslist" exact component={Accountslist}/>
    				<Route path="/Transfer" exact component={Transfer}/>
    				<Route path="/TransactionHistory" exact component={TransactionHistory}/>
    			</Switch>
			</Col>
    	</Container>
      
    </Router>
  );
}

export default App;
