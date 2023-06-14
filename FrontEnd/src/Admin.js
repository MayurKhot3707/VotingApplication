import React, { useState } from 'react';
import VoteHere from './components/VotingPage';
import VoteCount from './components/VoteCount';

function LoginForm() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');

  function handleSubmit(event) {
    event.preventDefault();

    fetch("http://localhost:8080/api/adminlogin", {
      method: 'POST',
      body: JSON.stringify({
        username,
        password
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(response => {
        if (response.ok) {
          console.log(response)
          setIsLoggedIn(true);
          setErrorMessage('');
        } else {
          setIsLoggedIn(false);
          setErrorMessage('Incorrect username or password.');
        }
      }).catch(error => {
        console.error('Login error:', error);
        setIsLoggedIn(false);
        setErrorMessage('An error occurred while logging in. Please try again later.');
      });
  }

  if (isLoggedIn) {
    return <VoteCount />;
  }

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Username:
        <input
          type="text"
          value={username}
          onChange={event => setUsername(event.target.value)}
        />
      </label>
      <br />
      <label>
        Password:
        <input
          type="password"
          value={password}
          onChange={event => setPassword(event.target.value)}
        />
      </label>
      <br />
      <button type="submit">Login</button>
      {errorMessage && <div>{errorMessage}</div>}
    </form>
  );
}

export default LoginForm;
