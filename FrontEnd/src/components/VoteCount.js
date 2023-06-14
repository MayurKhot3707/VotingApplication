import React, { useState, useEffect } from "react";

const VoteCount = () => {
  const [candidates, setCandidates] = useState([]);
  const [votedUsers, setVotedUsers] = useState([]);
  const [selectedCandidateId, setSelectedCandidateId] = useState(null); // added state to store selected candidate id

  useEffect(() => {
    fetch("http://localhost:8080/api/candidate")
      .then((response) => response.json())
      .then((data) => setCandidates(data))
      .catch((error) => console.log(error));
  }, []);

  const handleButtonClick = (candidateId) => {
    fetch(`http://localhost:8080/api/voteusers/${candidateId}`)
      .then((response) => response.json())
      .then((data) => {
        setVotedUsers(data);
        setSelectedCandidateId(candidateId); // update selected candidate id
  
        // Show list of voted users in an alert
       // const votedUserNames = votedUsers.map(user => user.username).join(', ');
        alert("Voted Users are : " + data);
      })
      .catch((error) => console.log(error));
  };

  console.log(votedUsers);
  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
      }}
    >
      <table
        style={{
          border: "1px solid black",
          width: "70%",
          textAlign: "center",
        }}
      >
        <thead style={{ backgroundColor: "#f2f2f2" }}>
          <tr>
            <th style={{ border: "1px solid black", padding: "10px" }}>
              Candidate ID
            </th>
            <th style={{ border: "1px solid black", padding: "10px" }}>
              Candidate Name
            </th>
            <th style={{ border: "1px solid black", padding: "10px" }}>
              Votes
            </th>
            <th style={{ border: "1px solid black", padding: "10px" }}>
              User Voted
            </th>
          </tr>
        </thead>
        <tbody>
          {candidates.map((candidate) => (
            <tr key={candidate.canid}>
              <td style={{ border: "1px solid black", padding: "10px" }}>
                {candidate.canid}
              </td>
              <td style={{ border: "1px solid black", padding: "10px" }}>
                {candidate.canname}
              </td>
              <td style={{ border: "1px solid black", padding: "10px" }}>
                {candidate.votecount}
              </td>
              <td style={{ border: "1px solid black", padding: "10px" }}>
                <button onClick={() => handleButtonClick(candidate.canid)}>
                  Voted Users
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default VoteCount;
