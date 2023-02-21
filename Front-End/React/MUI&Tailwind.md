## 6. Material UI vs Tailwind

### Material UI

Material UI는 React에서 가장 많이 사용되는 디자인 프레임워크, BootStrap UI와 비슷하지만 React안에서 만큼은 Material UI를 더 많이 선호한다.

### 설치

```bash
npm install @material-ui/core
```

### **공식문서**

[Overview - Material UI](https://mui.com/material-ui/getting-started/overview/)

### 적용 예시

간단한 테이블을 구현하기

```jsx
import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

function createData(
  name: string,
  calories: number,
  fat: number,
  carbs: number,
  protein: number,
) {
  return { name, calories, fat, carbs, protein };
}

const rows = [
  createData('Frozen yoghurt', 159, 6.0, 24, 4.0),
  createData('Ice cream sandwich', 237, 9.0, 37, 4.3),
  createData('Eclair', 262, 16.0, 24, 6.0),
  createData('Cupcake', 305, 3.7, 67, 4.3),
  createData('Gingerbread', 356, 16.0, 49, 3.9),
];

export default function BasicTable() {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Dessert (100g serving)</TableCell>
            <TableCell align="right">Calories</TableCell>
            <TableCell align="right">Fat&nbsp;(g)</TableCell>
            <TableCell align="right">Carbs&nbsp;(g)</TableCell>
            <TableCell align="right">Protein&nbsp;(g)</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row.name}
              </TableCell>
              <TableCell align="right">{row.calories}</TableCell>
              <TableCell align="right">{row.fat}</TableCell>
              <TableCell align="right">{row.carbs}</TableCell>
              <TableCell align="right">{row.protein}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
```

### TailWind

 Tailwind CSS 역시 화면 디자인을 위한 프레임워크이며 사용자 맞춤 디자인을 유틸리티 우선으로 빠르게 구축할 수 있는 CSS 프레임워크이다.

 따라서 MaterialUI와 조금 다른 성격을 가지고 있다. 차이점을 간략히 설명을 하자면 tailwind는 처음 부터 끝까지 내가 디자인을 해야 하고, Material UI는 만들어진 디자인을 가져다 쓰는 방식이다.

 그럼 Material UI가 더 편한 거 아닐까? 물론 만들어진 컴포넌트를 가져다 쓰는 방식이라 사용에 있어서는 편리하겠지만 세세한 디자인을 설정하기엔 번거로움이 많다. 반대로 Tailwind를 사용하면 섬세한 디자인을 직접할 수 있도록 편리한 UI를 제공한다.  

### 설치

```bash
npm install -D tailwindcss
npx tailwindcss init
```

### 공식문서

[Installation - Tailwind CSS](https://tailwindcss.com/docs)

### 적용 예시

border 적용한 테이블 만들기

```html
<table class="border-separate border border-slate-400 ...">
  <thead>
    <tr>
      <th class="border border-slate-300 ...">State</th>
      <th class="border border-slate-300 ...">City</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td class="border border-slate-300 ...">Indiana</td>
      <td class="border border-slate-300 ...">Indianapolis</td>
    </tr>
    <tr>
      <td class="border border-slate-300 ...">Ohio</td>
      <td class="border border-slate-300 ...">Columbus</td>
    </tr>
    <tr>
      <td class="border border-slate-300 ...">Michigan</td>
      <td class="border border-slate-300 ...">Detroit</td>
    </tr>
  </tbody>
</table>
```

### 정리

|  | Material UI | Tailwind |
| --- | --- | --- |
| 장점 | 만들어진 컴포넌트 제공 쉬운 UI 제작 | 커스텀 컴포넌트를 쉽게 만들 수 있음 |
| 단점 | 세세한 디자인 조절이 어려움 | 일일히 디자인을 해야하는 번거로움 |
| 사용하는 경우 | 정형화된 구조에 스타일링 요소가 많지 않을 때 | 비정형화된 구조에 스타일링 요소가 많을 때  |

### 우리 프로젝트는 어떤 방식을 적용해야 할까

 규모가 엄청난 서비스가 아니다 보니 둘 중 어떤 방식을 고르냐에 따라 큰 차이가 발생하진 않을 것 같아서 경험하고 싶은 분야를 선택하면 좋을 것 같다.

 그래서 나는 TailWind를 써보고 싶다고 생각한다.