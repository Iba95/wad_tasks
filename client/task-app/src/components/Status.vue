<template>
  <div id="status">
    <span
      v-if="status == 'Idea'"
      class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-blue-100 text-blue-800"
    >
      {{ status }}
    </span>
    <span
      v-if="status == 'In Review'"
      class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-blue-100 text-blue-800"
    >
      {{ status }}
    </span>
    <span
      v-if="status == 'Doing'"
      class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-yellow-100 text-yellow-800"
    >
      {{ status }}
    </span>
    <span
      v-if="status == 'Todo Next'"
      class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-red-100 text-red-800"
    >
      {{ status }}
    </span>
    <span
      v-if="status == 'Done'"
      class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"
    >
      {{ status }}
    </span>
  </div>
</template>

<script>
export default {
  name: "Status",
  props: {
    status: String,
  },
};
</script>


