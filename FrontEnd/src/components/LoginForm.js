import React, { useState, useEffect } from 'react';
import VoteCount from './VoteCount';
import VotingPage from './VotingPage';

function LoginForm() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [isAdminLoggedIn, setIsAdminLoggedIn] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');
  const [role, setRole] = useState('');

  function handleSubmit(event) {
    event.preventDefault();

    fetch("http://localhost:8080/api/login", 
    {
      method: 'POST',
      body: JSON.stringify({
        username,
        password,
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(response => {
      if (response.ok) {
        const contentType = response.headers.get('Content-Type');
        if (contentType && contentType.includes('application/json')) {
          response.json().then(data => {
            if (data.success) {
              console.log(response);
              console.log(data);
              sessionStorage.setItem('userid', JSON.stringify(data.user.userid));
              setRole(data.user.role);
              setErrorMessage('');
            } else {
              setIsLoggedIn(false);
              setErrorMessage('Sorry, your voting is done.');
            }
          });
        } else {
          setIsLoggedIn(false);
          setErrorMessage('Response is not in JSON format.');
        }
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

  useEffect(() => {
    if (role === "user") {
      setIsLoggedIn(true);
    } else if (role === "admin") {
      setIsAdminLoggedIn(true);
    }
  }, [role]);

  if (isAdminLoggedIn) {
    return <VoteCount />;
  }

  if (isLoggedIn) {
    return <VotingPage />;
  }

  return (
    <div className="registration-container">
    <form className='registration-form' onSubmit={handleSubmit}>
      <h1>Login page</h1>
      <label>
        Username:
        <input
          type="text"
          value={username}
          onChange={event => setUsername(event.target.value)}
        />
      </label>
      <br />
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
      <br />
      <button type="submit">Login</button>
      {errorMessage && <div>{errorMessage}</div>}
    </form>
    </div>
  );
}

export default LoginForm;
