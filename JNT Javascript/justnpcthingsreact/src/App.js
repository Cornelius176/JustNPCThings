import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import logo from './logo.svg';
import './App.css';

function Welcome(props) {
	return <h1 className="App-title">Hello, {props.name}</h1>;
}

class App extends Component {
	render() {
		return (
			<div className="App">
				<header className="App-header">
					<img src={logo} className="App-logo" alt="logo" />
					<Welcome name="Sara" />
					<Welcome name="Cahal" />
					<Welcome name="Edite" />
				</header>
			</div>
		);
	}
}

ReactDOM.render(
  <App />,
  document.getElementById('root')
);

export default App;
