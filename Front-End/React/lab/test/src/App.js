import "./App.css";

function App() {
  return (
    <div className="App flex-col justify-between h-screen">
      <header className="App-header fixed top-0 bg-white w-full h-10">
        헤더 메뉴
      </header>
      <div className="h-full py-10 overflow-y-auto">
        <img src="https://picsum.photos/300/300" alt="랜덤이미지" />
        <img src="https://picsum.photos/300/300" alt="랜덤이미지" />
        <img src="https://picsum.photos/300/300" alt="랜덤이미지" />
        <img src="https://picsum.photos/300/300" alt="랜덤이미지" />
        <img src="https://picsum.photos/300/300" alt="랜덤이미지" />
      </div>
      <footer className="fixed bottom-0 h-10 w-full bg-green-600">
        하단 메뉴바
      </footer>
    </div>
  );
}

export default App;
