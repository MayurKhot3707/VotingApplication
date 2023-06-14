import logo from './logo.svg';
import './App.css';
import RegistrationForm from './components/RegistrationForm';
import LoginForm from './components/LoginForm';
import VotingPage from './components/VotingPage';
import {BrowserRouter,Route,Rotes, Routes} from 'react-router-dom';
import Home from './Home';
import RegistrationPage from './components/RegistrationForm';
import Admin from './Admin';
import VoteCount from './components/VoteCount';
import CandidateRegister from './components/CandidateRegister';

function App() {
  return (
   <BrowserRouter>
   <Routes>
    <Route path='/' element={<Home/>}/>
    <Route path='/Login' element={<LoginForm/>}/>
    <Route path='/Register' element={<RegistrationPage/>}/>
    <Route path='/AdminLogin' element={<Admin/>}/>
    <Route path='/VoteCount' element={<VoteCount/>}/>
    <Route path='/CandidateRegister' element={<CandidateRegister/>}/>
   </Routes>
   </BrowserRouter>
  );
}

export default App;
