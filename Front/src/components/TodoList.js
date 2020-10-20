import React from 'react';
import {Todo} from './Todo'
import { Box } from '@material-ui/core';

export class TodoList extends React.Component {

    render() {
        const todoList = this.props.todoList.map((todo, i) => {
            if(todo!= null){
            return (
                <Todo key={i} description={todo.description} name={todo.nameResponsible} email={todo.emailResponsible} status={todo.status}  dueDate={todo.dueDate}/>
                );
            }
        });
        return (
            <Box component="span" display="block" p={1} m={1}  >
                {todoList}
            </Box>
        );


    }

}