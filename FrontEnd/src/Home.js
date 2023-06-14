import LoginForm from "./components/LoginForm";
import RegistrationPage from "./components/RegistrationForm";
import './App.css'; // Import CSS file for styling


export default function Home() {
  return (
    <div>
      <div className="home-container">
        <br />
        <br />
        <a href="/Login">
          <button style={{fontSize: '20px', padding: '10px 20px',backgroundColor: 'blue',color:'white',cursor:'pointer'}}>Login</button>
        </a>
        <br />
        <br />
        <a href="/Register">
          <button style={{fontSize: '20px', padding: '10px 20px',backgroundColor: 'blue',color:'white',cursor:'pointer'}}>Register</button>
        </a>
        <br />
        <br />
        <br />
        <br />
        <a href="/CandidateRegister">
          <button style={{fontSize: '20px', padding: '10px 20px',backgroundColor: 'blue',color:'white',cursor:'pointer'}}>Add Candidate</button>
        </a>
        <br />
        <br />
      </div>
    </div>
  );
}
