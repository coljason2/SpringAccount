Vue.component( 'todo-item' , {
  props: ['todo', 'index', 'filter'],
  template:`<li>
    <td>
    <input type="checkbox" v-on:change="updateStatus(todo)" :checked="todo.isCompleted">
    
    <label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.name }}</label>
    <input type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.name" />
	</td>
	<td>
    <label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.inputday }}</label>
    <input  id="inputday" name="inputday" type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.inputday" />
	</td>
	<td>
	<label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.cost }}</label>
    <input type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.cost" />
	</td>
	<td>
	<label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.count }}</label>
    <input type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.count" />	
	</td>
	<td>
	<label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.discount1 }}</label>
    <input type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.discount1" />
	</td>
	<td>
	<label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.discount2 }}</label>
    <input type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.discount2" />
	</td>
	<td>
	<label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.discount3 }}</label>
    <input type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.discount3" />
	</td>
	<td>
	<label v-if="!todo.isEdit" v-bind:class="[todo.isCompleted ? 'completed' : '']">{{ todo.total }}</label>
    <input type="text" v-if="todo.isEdit" v-on:keyup.enter="updateTodo($event, todo)" v-model="todo.total" />
	
    <a v-on:click="editTodo(todo)" v-if="!todo.isEdit" class="btn">編輯</a>
    <a v-on:click="remove(index)" class="btn">刪除</a>
 	</td>
  </li>`,
  methods: {
    remove: function(index) {
      this.$emit('remove');
    },
    updateTodo: function($event, todo) {
      if($event.target.value) {
        todo.text = $event.target.value;
      }
      todo.isEdit = !todo.isEdit;
    },
    updateStatus: function(todo) {
      todo.isCompleted = !todo.isCompleted;
    },
    editTodo: function(todo) {
      todo.isEdit = !todo.isEdit;
    },
    showCompletedTodo: function(isCompleted, filter) {
      return !(!isCompleted && filter === 'show_completed');
    }
  }
});

var app = new Vue({
  el: '#app',
  data: {
    todos: {},
    newTodoText: '',
    company: '選擇藥品公司',
    inputday:'',
	name: '選擇藥品',
	cost: 0,
	count: 0,
	discount1: 0,
	discount2: 0,
	discount3: 0,
	total:     0,
    filter: 'show_all'
  },
  computed: {
    todosData: function() {
      return JSON.stringify(this.todos);
    },
	totalResult: function() {
	  return this.total = this.cost - this.discount1
				- this.discount2 - this.discount3;
	  },
    list: function() {
      if(this.filter === 'show_all') {
        return this.todos;
      } else if (this.filter === 'show_completed') {
        return this._getTodos(true);
      } else { //show_incomplete
        return this._getTodos(false);
      }
    },
    allCount: function() {
      return Object.keys(this.todos).length;
    },
    completedCount: function() {
      var _this = this;

      return Object.keys(this.todos).filter(function(value) {
        return _this.todos[value].isCompleted
      }).length;
    },
    incompleteCount: function() {
      var _this = this;

      return Object.keys(this.todos).filter(function(value) {
        return !_this.todos[value].isCompleted
      }).length;
    }
  },
  methods: {
    add: function() {
      var id = this._uuid();

      Vue.set(this.todos, id, {
        uuid: id,
        text: this.newTodoText,
		name: this.name,
		cost: this.cost,
		count: this.count,
		discount1: this.discount1,
		discount2: this.discount2,
		discount3: this.discount3,
		total:     this.total,
        isCompleted: false,
        company: this.company,
        inputday: this.inputday,
        isEdit: false
      });
      this.company ='選擇藥品公司';
      this.inputday    = '';
      this.newTodoText = '';
	  this.name ='選擇藥品';
	  this.cost= 0;
	  this.count=0;
	  this.discount1= 0;
	  this.discount2= 0;
	  this.discount3= 0;
	  this.total=     0;
    },
    del: function(index) {
      Vue.delete(this.todos, index);
    },
    setFilter: function(filter) {
      this.filter = filter;
    },
    _uuid: function() {
      var d = Date.now();
      if (typeof performance !== 'undefined' && typeof performance.now === 'function'){
          d += performance.now(); //use high-precision timer if available
      }
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
          var r = (d + Math.random() * 16) % 16 | 0;
          d = Math.floor(d / 16);
          return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
      });
    },
    _getTodos: function(isCompleted) {
      var list = {};

      for(var index in this.todos) {
        if(this.todos[index].isCompleted === isCompleted) {
          list[index] = this.todos[index];
        }
      }
      return list;
    },
    _getObjContent: function (data) {
      return  Object.keys(data).map(function(index){
        return data[index];
      });
    }
  }
});
