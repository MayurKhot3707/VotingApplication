import React, { useState } from 'react'; 
import App from '../App.css';
function RegistrationPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [mobilenumber, setMobileNumber] = useState('');
  const [role, setRole] = useState('user');

  function handleSubmit(event) {
    event.preventDefault();
    console.log(username, password, email, mobilenumber, role);

    fetch("http://localhost:8080/api/users", {
      method: 'POST',
      body: JSON.stringify({
        username,
        password,
        email,
        mobilenumber,
        role,
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then(response => {
        if (response.ok) {
          alert('Registration successful!');
          window.location.href = "/";
        } else {
          alert('Registration failed.');
        }
      })
      .catch(error => {
        console.error('Registration error:', error);
        alert('Registration failed.');
      });
  }

  return (
    <div className="registration-container">
      <form className="registration-form" onSubmit={handleSubmit}>
        <h1>Registration page</h1>
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
        <label>
          Email:
          <input
            type="email"
            value={email}
            onChange={event => setEmail(event.target.value)}
          />
        </label>
        <br />
        <label>
          Mobile Number:
          <input
            type="text"
            value={mobilenumber}
            onChange={event => setMobileNumber(event.target.value)}
          />
        </label>
        <br />
        <label>
          Role:
          <input
            type="text"
            value={role}
            onChange={event => setRole(event.target.value)}
          />
        </label>
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default RegistrationPage;
