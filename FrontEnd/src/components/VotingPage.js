import React, { useState, useEffect } from "react";

export default function VotingPage() {
  const [selectedOption, setSelectedOption] = useState("");
  const [candidates, setCandidates] = useState([]);
  const [userId, setUserId] = useState("");

  useEffect(() => {
    // Get user ID from session storage
    const userIdFromStorage = sessionStorage.getItem("userid");
    setUserId(userIdFromStorage);

    fetch("http://localhost:8080/api/candidate")
      .then(response => response.json())
      .then(data => setCandidates(data))
      .catch(error => alert(error));
  }, []);

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Create a voting object with user ID and selected candidate ID
    const votingObject = {
      "userid": userId,
      "candidateid": selectedOption
    };

    // Send voting object to server
    fetch("http://localhost:8080/api/vote", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(votingObject)
    })
      .then(response => {
        if (response.ok) {
          alert("Thank you for voting!");
          window.location.href = "/";
        } else {
          throw new Error("Voting failed");
        }
      })
      .catch(error => alert(error));
  };

  const handleLogout = () => {
    // Delete user ID from session storage and redirect to home page
    sessionStorage.removeItem("user");
    // Navigate to home page
    window.location.href = "/";
  };

  return (
    <div className="page-container">
      <form className="registration-form" onSubmit={handleSubmit}>
        {candidates.map(candidate => (
          <div key={candidate.canid} className="candidate-option">
            <input
              type="radio"
              value={candidate.canid.toString()}
              checked={selectedOption === candidate.canid.toString()}
              onChange={handleOptionChange}
            />
            <label>{candidate.canname}</label>
          </div>
        ))}
        <div className="button-container">
          <button type="submit">Submit</button>
          <button onClick={handleLogout}>Logout</button>
        </div>
      </form>
    </div>
  );
}
