import React, { useState } from 'react';
import App from '../App.css';

function RegistrationPage() {
  const [canname, setCanname] = useState('');

  function handleDelete() {
    // Delete candidate logic
    fetch(`http://localhost:8080/api/candidate/${canname}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then(response => {
        if (response.ok) {
          alert('Candidate deleted successfully!');
          // Remove the candidate from the table without adding it first
          setCanname('');
        } else {
          alert('Candidate deletion failed.');
        }
      })
      .catch(error => {
        console.error('Candidate deletion error:', error);
        alert('Candidate deletion failed.');
      });
  }
  

  function handleSubmit(event) {
    event.preventDefault();
    console.log(canname);

    fetch('http://localhost:8080/api/candidate', {
      method: 'POST',
      body: JSON.stringify({
        canname,
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then(response => {
        if (response.ok) {
          alert('Registration successful!');
          window.location.href = '/';
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
      <form className="registration-form" >
        <div>
          <h1>Registration page</h1>
          <label>
            Username:
            <input
              type="text"
              value={canname}
              onChange={event => setCanname(event.target.value)}
            />
          </label>
          <br />
          <button onClick={handleSubmit}>Register</button>
        </div>
        <div>
          <button onClick={handleDelete}>Delete Candidate</button>
          {/* New button for deleting candidate */}
        </div>
      </form>
    </div>
  );
}

export default RegistrationPage;
