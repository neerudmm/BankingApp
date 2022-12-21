import React, { Component } from 'react'
import {Jumbotron} from 'react-bootstrap';

export default class Welcome extends Component {
	render () {
		return (
			<Jumbotron className="bg-dark text-white">
				  <h1>Banking</h1>
				  <p>
				    REST API based Banking App
				  </p>
			</Jumbotron>
		)
	}
}