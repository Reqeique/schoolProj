import "./App.css";
import HeroContent from "./components/HeroContent";
import Header from "./components/Header";
import About from "./components/About";

function App() {
  return (
    <div className="App">
      <div className="Home">
        <Header />
        <HeroContent />
        <About />
      </div>
    </div>
  );
}

export default App;
