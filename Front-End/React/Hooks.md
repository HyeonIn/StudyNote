# Hooks

## Hook?

- 리액트 v16.8 이후에 새로 도입된 기능으로 함수형 컴포넌트에서도 상태 관리를 할 수 있는 useState, 렌더링 직후 작업을 설정하는 useEffect 등의 기능을 제공하여 기존의 함수형 컴포넌트에서 할 수 없었던 다양한 작업을 할 수 있게 되었다

### useState

- 가장 기본적인 Hook 이며, 함수형 컴포넌트에서도 가변적인 상태를 지닐 수 있게 해준다
- 함수형 컴포넌트에서 상태를 관리해야 할 때 사용

```javaScript
const [value, setValue] = useState(0); 
```

- useState 함수의 파라미터에는 상태의 기본값을 넣어준다
- 이 함수가 호출되면 [상태 값, 상태 설정함수]로 이루어진 배열이 반환된다.

#### useState 여러 번 사용하기

- 하나의 useState 함수는 하나의 상태 값만 관리할 수 있음
- 컴포넌트에서 관리해야 할 상태가 여러 개라면 useState를 여러 번 사용하면 됨

### useEffect

- 리액트 컴포넌트가 렌더링 될 때마다 특정 작업을 수행하도록 설정할 수 있는 Hook
- 클래스형 컴포넌트의 componentDidMount와 componentDidUpdate를 합친 형태로 보아도 무방

#### 마운트될 때만 실행하고 싶을 때

- useEffect 함수의 두 번째 파라미터로 비어있는 배열을 넣어주면 된다

```javaScript
    useEffect(() => {
        cnosole.log('마운트 될 때만 실행')
    }, []);
```

#### 특정 값이 업데이트될 때만 실행하고 싶을 때

- useEffect 함수의 두 번째 파라미터 배열 안에 검사하고 싶은 값을 넣어준다

```javaScript
    useEffect(() => {
        cnosole.log(name)
    }, [name]);
```

#### 뒷정리하기

- useEffect는 기본적으로 렌더링되고 난 직후마다 실행되며, 두 번째 파라미터 배열에 무엇을 넣는지에 따라 실행되는 조건이 달라진다
- 컴포넌트가 언마운트 되기 전이나 업데이트 되기 직전에 어떠한 작업을 수행하고 싶다면 useEffect에서 cleanUp 함수를 반환해 주어야 한다

